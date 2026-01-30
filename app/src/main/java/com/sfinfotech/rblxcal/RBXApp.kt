package com.sfinfotech.rblxcal

import android.app.Application
import com.sfinfotech.rblxcal.util.ActivityTracker
import com.sfinfotech.rblxcal.util.DataUtil
import com.sfinfotech.rblxcal.util.RemoteConfigHelper

class RBXApp : Application() {


    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(ActivityTracker)

        DataUtil.init(this)
        RemoteConfigHelper.init()

    }
}