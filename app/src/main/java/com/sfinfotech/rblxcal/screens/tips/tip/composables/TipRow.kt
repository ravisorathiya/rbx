package com.sfinfotech.rblxcal.screens.tips.tip.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sfinfotech.rblxcal.screens.tips.tip.TipIcon
import com.sfinfotech.rblxcal.screens.tips.tip.TipItem
import com.sfinfotech.rblxcal.screens.tips.tip.TipItemType

@Composable
fun TipRow(
    item: TipItem,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF1C1C1E),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconContainer(icon = item.icon)

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = item.title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )

            if (item.type == TipItemType.GAME_AD) {
                AdBadge()
            }
        }
    }
}

@Preview(
    name = "Tip Item",
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun TipRowPreview_Tip() {
    TipRow(
        item = TipItem(
            id = "1",
            title = "Managing your Robx Balance",
            icon = TipIcon.BULB,
            type = TipItemType.TIP,
            description = "Managing your Robx BalanceManaging your Robx BalanceManaging your Robx BalanceManaging your Robx BalanceManaging your Robx BalanceManaging your Robx BalanceManaging your Robx BalanceManaging your Robx BalanceManaging your Robx BalanceManaging your Robx Balance"
        ),
        onClick = {}
    )
}

