package com.sfinfotech.rblxcal.util

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import com.sfinfotech.rblxcal.core.settings.SettingActivity
import com.sfinfotech.rblxcal.core.splash.SplashActivity
import com.sfinfotech.rblxcal.screens.ad.WebAdActivity
import com.sfinfotech.rblxcal.screens.main.MainActivity
import com.sfinfotech.rblxcal.util.Util.EXIT_AD_SHOW

object ActivityTracker : Application.ActivityLifecycleCallbacks {

    var counter = 0

    private val activityStack = mutableListOf<Activity>()

    val currentActivity: Activity?
        get() = activityStack.lastOrNull()

    val activityCount: Int
        get() = activityStack.size

    fun getAllActivities(): List<Activity> = activityStack.toList()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        activityStack.add(activity)
        if (activity is SplashActivity) return
        if (activity is WebAdActivity) return
        if (activity is SettingActivity) return

        val intent = Intent(activity, WebAdActivity::class.java)
        activity.startActivity(intent)
    }

    override fun onActivityDestroyed(activity: Activity) {
        activityStack.remove(activity)
        if (activity is SplashActivity) return
        if (activity is WebAdActivity) return
        if (activity is MainActivity) return

        counter++
        if (counter % EXIT_AD_SHOW == 0) {
            val intent = Intent(activity, WebAdActivity::class.java)
            activity.startActivity(intent)
        }

    }

    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
}
