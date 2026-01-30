package com.sfinfotech.rblxcal.util

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.sfinfotech.rblxcal.model.CalcType
import com.sfinfotech.rblxcal.model.ConvertModel

object Util {

    var adLink by mutableStateOf("https://48.mark.qureka.com/intro/question")
    var privacyPolicy by mutableStateOf("https://www.google.com/")

    val PRIMARY__COLOR = Color(0xFF22a7f2)


    const val EXIT_AD_SHOW = 3


    val convertModelList = CurrencyModelEnum.entries.map {
        ConvertModel(
            title = it.title,
            subTitle = it.subTitle,
            icon = it.icon,
            span = it.span,
            isAd = it == CurrencyModelEnum.PLAY_GAME_AD ||
                    it == CurrencyModelEnum.PLAY_GAME_AD_2
        )
    }

    fun calculate(type: CalcType, amount: Double): Double {
        return when (type) {
            CalcType.USD_TO_RBX -> amount * 80
            CalcType.RBX_TO_USD -> amount / 80
            CalcType.RBX_TO_DOLLAR -> amount / 80
            CalcType.DOLLAR_TO_RBX -> amount * 80
            CalcType.BC_TO_RBX -> amount * 10
            CalcType.TBC_TO_RBX -> amount * 12
            CalcType.OBC_TO_RBX -> amount * 15
            else -> 1.0
        }
    }

    @Composable
    fun rememberIsNetworkAvailable(): State<Boolean> {
        val context = LocalContext.current
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // 🔹 Get REAL current network status immediately
        val initialState = remember {
            val network = connectivityManager.activeNetwork
            val caps = connectivityManager.getNetworkCapabilities(network)
            caps?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true &&
                    caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        }

        val networkState = remember { mutableStateOf(initialState) }

        DisposableEffect(Unit) {
            val callback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    networkState.value = true
                }

                override fun onLost(network: Network) {
                    networkState.value = false
                }

                override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                    networkState.value =
                        caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                                caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                }
            }

            val request = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()

            connectivityManager.registerNetworkCallback(request, callback)

            onDispose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }

        return networkState
    }

    fun openNetworkSettings(context: Context) {
        try {
            context.startActivity(
                Intent(Settings.ACTION_WIRELESS_SETTINGS).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
            )
        } catch (e: Exception) {
            FirebaseCrashlytics.getInstance().recordException(e)
        }
    }

}