package com.app.lock.code.rbx.util

import android.app.Activity
import android.content.Intent
import com.app.lock.code.rbx.screens.memes.MemesActivity
import com.app.lock.code.rbx.screens.sctach.ScrtachCardActivity
import com.app.lock.code.rbx.screens.spin.SpinActivity
import com.app.lock.code.rbx.screens.tips.tip.TipsActivity

object AppNavigator {


    fun toScratchCard(activity : Activity) {
        val intent = Intent(activity, ScrtachCardActivity::class.java)
        activity.startActivity(intent)
    }

    fun toSpin(activity : Activity) {
        val intent = Intent(activity, SpinActivity::class.java)
        activity.startActivity(intent)

    }
    fun toMeme(activity : Activity) {
        val intent = Intent(activity, MemesActivity::class.java)
        activity.startActivity(intent)

    }
    fun toTips(activity : Activity) {
        val intent = Intent(activity, TipsActivity::class.java)
        activity.startActivity(intent)

    }
}