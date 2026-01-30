package com.sfinfotech.rblxcal.screens.main.composables

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sfinfotech.rblxcal.R

@Composable
fun ImageButtonCard(icon: Int,onClick : () -> Unit) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color.Black)
            .clickable(onClick = onClick)
        ,

        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(
                color = Color.White
            )

        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageButtonCardPreview() {
    ImageButtonCard(
        icon = R.drawable.calc,
        onClick = {  }
    )
}