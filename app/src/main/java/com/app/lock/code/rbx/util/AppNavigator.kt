package com.app.lock.code.rbx.util

import android.app.Activity
import android.content.Intent
import com.app.lock.code.rbx.screens.calc.CalcActivity
import com.app.lock.code.rbx.screens.calc.CalcItem
import com.app.lock.code.rbx.screens.memes.MemesActivity
import com.app.lock.code.rbx.screens.quiz.QuizActivity
import com.app.lock.code.rbx.screens.result.CalResultActivity
import com.app.lock.code.rbx.screens.sctach.ScrtachCardActivity
import com.app.lock.code.rbx.core.settings.SettingActivity
import com.app.lock.code.rbx.screens.spin.SpinActivity
import com.app.lock.code.rbx.screens.tips.tip.TipsActivity
import kotlin.jvm.java

object AppNavigator {


    fun toCalc(activity : Activity) {
        val intent = Intent(activity, CalcActivity::class.java)
        activity.startActivity(intent)
    }

    fun toCalcResult(activity : Activity,item : CalcItem) {
        val intent = Intent(activity, CalResultActivity::class.java)
        intent.putExtra("type", item.type.name)
        activity.startActivity(intent)
    }

    fun toScratchCard(activity : Activity) {
        val intent = Intent(activity, ScrtachCardActivity::class.java)
        activity.startActivity(intent)
    }

    fun toSpin(activity : Activity) {
        val intent = Intent(activity, SpinActivity::class.java)
        activity.startActivity(intent)

    }

    fun toQuiz(activity : Activity) {
        val intent = Intent(activity, QuizActivity::class.java)
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

    fun toSetting(activity : Activity) {
        val intent = Intent(activity, SettingActivity::class.java)
        activity.startActivity(intent)

    }
}