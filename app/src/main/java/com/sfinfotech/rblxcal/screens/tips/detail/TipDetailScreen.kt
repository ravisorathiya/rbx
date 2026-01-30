package com.sfinfotech.rblxcal.screens.tips.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sfinfotech.rblxcal.screens.tips.tip.TipIcon
import com.sfinfotech.rblxcal.screens.tips.tip.TipItem
import com.sfinfotech.rblxcal.screens.tips.tip.TipItemType
import com.sfinfotech.rblxcal.screens.tips.detail.composables.BottomAdBanner
import com.sfinfotech.rblxcal.screens.tips.detail.composables.TopBar

@Composable
fun TipDetailScreen(
    tipItem: TipItem?,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopBar(onBackClick)
        },
        bottomBar = {
            BottomAdBanner()
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {

            Text(
                text = tipItem?.title.orEmpty(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = tipItem?.description.orEmpty(),
                fontSize = 16.sp,
                color = Color(0xFFBDBDBD),
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(120.dp)) // space above ad
        }
    }
}

@Preview(
    name = "Tip Detail Screen",
    showBackground = true,
    backgroundColor = 0xFF000000,
    showSystemUi = true
)
@Composable
fun TipDetailScreenPreview() {
    TipDetailScreen(
        tipItem = TipItem(
            id = "1",
            title = "Staying informed with App Updates",
            description = "Staying informed with app updates is key to unlocking the full potential of your Robx App experience. Regular updates bring exciting new features, smoother performance, improved security, and fresh opportunities to earn even more Robx. Behind the scenes, the team works tirelessly to fix bugs, optimize the interface, and roll out exclusive rewards and limited-time events. By keeping your app up to date, you gain access to enhanced tools, smarter systems, and bonus activities designed to boost your balance.",
            icon = TipIcon.BULB,
            type = TipItemType.TIP
        ),
        onBackClick = {}
    )
}
