package com.sfinfotech.rblxcal.core.settings

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.sfinfotech.rblxcal.util.Util

object SettingUtil {

    fun shareApp(context: Context) {
        val packageName = context.packageName

        val shareText = """
        🎮 I'm using this awesome RBX rewards app!
        Try it now and earn free rewards 👇
        
        https://play.google.com/store/apps/details?id=$packageName
    """.trimIndent()

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }

        context.startActivity(Intent.createChooser(intent, "Share App"))
    }


    fun rateApp(context: Context) {
        val packageName = context.packageName

        try {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$packageName")
                ).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            )
        } catch (e: ActivityNotFoundException) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                ).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openPrivacyPolicy(context: Context) {

        context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(Util.privacyPolicy)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        )
    }
}
