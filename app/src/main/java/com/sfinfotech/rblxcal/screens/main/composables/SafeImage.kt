package com.sfinfotech.rblxcal.screens.main.composables

import android.R.attr.contentDescription
import androidx.activity.compose.LocalActivity
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.sfinfotech.rblxcal.util.AppNavigator

@Composable
fun SafeImage(
    @DrawableRes resId: Int?,
    modifier: Modifier = Modifier
) {
    val activity = LocalActivity.current ?: return
    if (resId != null) {
        Image(
            painter = painterResource(resId),
            contentDescription = null,
            modifier = modifier.clickable(onClick = {
                AppNavigator.toAd(activity)
            }),
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = modifier.background(Color.DarkGray)
        )
    }
}
