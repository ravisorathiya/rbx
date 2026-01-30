package com.sfinfotech.rblxcal.screens.result

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sfinfotech.rblxcal.model.CalcType
import com.sfinfotech.rblxcal.ui.theme.RbxTheme

class CalResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val typeName = intent.getStringExtra("type") ?: CalcType.USD_TO_RBX.name
        val type = CalcType.valueOf(typeName)

        setContent {
            RbxTheme {
                CalcResultScreen(type = type) {
                    finish()
                }
            }
        }
    }}

