package com.app.lock.code.rbx.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.app.lock.code.rbx.R
import com.app.lock.code.rbx.model.ConvertModel

@Composable
fun CurrencyCalcCard(item: ConvertModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.8f)),
    ) {

        Image(
            painter = painterResource(item.icon),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(item.title)
        Text(item.subTitle)


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CurrencyCalcCardPreview() {
    CurrencyCalcCard(
        item = ConvertModel(
            title = "title",
            subTitle = "subtitle",
            icon = R.drawable.ic_launcher_background
        )
    )
}