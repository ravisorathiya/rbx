package com.sfinfotech.rblxcal.util

import android.app.Activity
import android.content.Intent
import com.sfinfotech.rblxcal.screens.calc.CalcActivity
import com.sfinfotech.rblxcal.screens.calc.CalcItem
import com.sfinfotech.rblxcal.screens.memes.MemesActivity
import com.sfinfotech.rblxcal.screens.quiz.QuizActivity
import com.sfinfotech.rblxcal.screens.result.CalResultActivity
import com.sfinfotech.rblxcal.screens.sctach.ScrtachCardActivity
import com.sfinfotech.rblxcal.core.settings.SettingActivity
import com.sfinfotech.rblxcal.screens.ad.WebAdActivity
import com.sfinfotech.rblxcal.screens.spin.SpinActivity
import com.sfinfotech.rblxcal.screens.tips.tip.TipsActivity
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

    fun toAd(activity : Activity) {
        val intent = Intent(activity, WebAdActivity::class.java)
        activity.startActivity(intent)

    }
}