package com.app.lock.code.rbx.screens.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.app.lock.code.rbx.ui.theme.RbxTheme
import com.app.lock.code.rbx.util.DataUtil
import kotlinx.coroutines.launch

class QuizActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RbxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val scope = rememberCoroutineScope()

                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        var showResult by remember { mutableStateOf(false) }
                        var score by remember { mutableStateOf(0) }

                        if (!showResult) {
                            QuizScreen(
                                onQuizFinished = {
                                score = it
                                showResult = true
                                },
                                onBackClick = ::finish
                            ) 
                        } else {
                            QuizResultScreen(
                                score = score,
                                onAddToWallet = {
                                    scope.launch {
                                        DataUtil.incrementCoins(it)
                                    }
                                },
                                onBackClick = ::finish
                            ) 
                        }
                    }

                }
            }
        }
    }
}
