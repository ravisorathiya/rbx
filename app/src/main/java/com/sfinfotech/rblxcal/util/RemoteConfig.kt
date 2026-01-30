package com.sfinfotech.rblxcal.util

import com.google.firebase.Firebase
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

object RemoteConfigHelper {

    private val remoteConfig = Firebase.remoteConfig

    fun init() {
        try {
            val configSettings = remoteConfigSettings {
                minimumFetchIntervalInSeconds = 0 // allow immediate fetch
            }

            remoteConfig.setConfigSettingsAsync(configSettings)

            remoteConfig.setDefaultsAsync(
                mapOf("ad_link" to Util.adLink)
            )

            // First fetch on app start
            remoteConfig.fetchAndActivate().addOnCompleteListener {
                updateAdLink()
            }
        } catch (e: Exception) {
            FirebaseCrashlytics.getInstance().recordException(e)
        }

        // 🔥 REAL-TIME LISTENER
        remoteConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
            override fun onUpdate(configUpdate: ConfigUpdate) {

                if (configUpdate.updatedKeys.contains("ad_link")) {

                    remoteConfig.activate().addOnCompleteListener {
                        updateAdLink()
                    }
                }
            }

            override fun onError(error: FirebaseRemoteConfigException) {
                FirebaseCrashlytics.getInstance().recordException(error)
            }
        })
    }

    private fun updateAdLink() {
        val newLink = remoteConfig.getString("ad_link")
        if (newLink.isNotBlank() && newLink != Util.adLink) {
            Util.adLink = newLink // 🔥 Compose UI updates instantly
        }

        val privacy = remoteConfig.getString("privacy_policy")
        if (newLink.isNotBlank() && newLink != Util.privacyPolicy) {
            Util.privacyPolicy = privacy // 🔥 Compose UI updates instantly
        }
    }
}
