package com.app.lock.code.rbx.screens.main.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lock.code.rbx.R
import com.app.lock.code.rbx.model.ConvertModel

@Composable
fun CurrencyCalcCard(item: ConvertModel) {

    val minHeight = if (item.span == 2) 90.dp else 150.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()

//            .heightIn(max = minHeight)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFF1C1C1E))
            .padding(16.dp)
    ) {

        // ─── AD TAG ─────────────────────────────
        if (item.isAd && item.span == 1) {
            Box(
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                AdTag()
            }
        }

        if (item.span == 2) {
            // FULL WIDTH
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                ImageButtonCard(item.icon)

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = item.title,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Text(
                        text = item.subTitle,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
        } else {
            // HALF WIDTH
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                ,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                ImageButtonCard(item.icon)

                Column {
                    Text(
                        text = item.title,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Text(
                        text = item.subTitle,
                        color = Color.Gray,
                        fontSize = 12.sp,
                        minLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CurrencyCalcCardPreview() {
    CurrencyCalcCard(
        item = ConvertModel(
            title = "title",
            subTitle = "subtitle subtitle subtitle subtitle subtitlesubtitlesubtitlesubtitlesubtitlesubtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle subtitle ",
            icon = R.drawable.calc,
            span = 1,
            isAd = true
        )
    )
}