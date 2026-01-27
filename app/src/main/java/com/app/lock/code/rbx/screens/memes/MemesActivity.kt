package com.app.lock.code.rbx.screens.memes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.app.lock.code.rbx.ui.theme.RbxTheme

class MemesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RbxTheme {

                val context = LocalContext.current

                MemesScreen(
                    onBackClick = { finish() },
                    onShareClick = { meme ->
                        MemeUtil.shareMeme(context, meme)
                    }
                )
            }
        }
    }
}


