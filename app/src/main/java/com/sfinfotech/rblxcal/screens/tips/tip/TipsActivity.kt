package com.sfinfotech.rblxcal.screens.tips.tip

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sfinfotech.rblxcal.screens.tips.detail.TipDetailActivity
import com.sfinfotech.rblxcal.ui.theme.RbxTheme
import kotlin.jvm.java

class TipsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RbxTheme {
                TipsScreen(
                    onItemClick = { item ->
                        val intent = Intent(this, TipDetailActivity::class.java)
                        intent.putExtra("tip_item", item)
                        startActivity(intent)
                    },
                    onBackClick = ::finish
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipScreenPreview() {

    TipsScreen(
        onItemClick = { },
        onBackClick = {  }
    )
}