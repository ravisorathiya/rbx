package com.sfinfotech.rblxcal.util

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

object DataUtil {

    private lateinit var appContext: Context
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val Context.dataStore by preferencesDataStore(name = "rbx_prefs")
    private val RBX_KEY = intPreferencesKey("rbx_coin_count")

    // 🔹 Compose observable state
    var rbxCoins by mutableStateOf(0)
        private set

    fun init(context: Context) {
        appContext = context.applicationContext
        observeCoins()
    }

    // 🔹 Flow observer updates Compose state automatically
    private fun observeCoins() {
        scope.launch {
            appContext.dataStore.data
                .map { prefs -> prefs[RBX_KEY] ?: 0 }
                .distinctUntilChanged()
                .collect { coins ->
                    rbxCoins = coins
                }
        }
    }

    // 🔹 Increment coins
    suspend fun incrementCoins(amount: Int) {
        appContext.dataStore.edit { prefs ->
            val current = prefs[RBX_KEY] ?: 0
            prefs[RBX_KEY] = current + amount
        }
    }

    // 🔹 Set exact value
    suspend fun setCoins(amount: Int) {
        appContext.dataStore.edit { prefs ->
            prefs[RBX_KEY] = amount
        }
    }

    // 🔹 Decrement safely
    suspend fun decrementCoins(amount: Int) {
        appContext.dataStore.edit { prefs ->
            val current = prefs[RBX_KEY] ?: 0
            prefs[RBX_KEY] = (current - amount).coerceAtLeast(0)
        }
    }
}
