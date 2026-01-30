package com.sfinfotech.rblxcal.screens.main.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sfinfotech.rblxcal.R

@Composable
fun FakeAdCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF121212))
    ) {

        // ─── Top Banner Image ───────────────
//        Image(
//            painter = painterResource(R.drawable.ethereum), // small banner
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(60.dp),
//            contentScale = ContentScale.Crop
//        )

        SafeImage(
            resId = R.drawable.ad, // null-safe
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        )

//        // ─── Main Content ──────────────────
//        Column(
//            modifier = Modifier
//                .padding(12.dp)
//                .fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Image(
////                painter = painterResource(R.drawable.ad_banner_top), // big image
//                painter = painterResource(R.drawable.ad), // big image
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(160.dp),
//                contentScale = ContentScale.Crop
//            )
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            Text(
//                text = "MIMIN COBAIN",
//                color = Color.White,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            )
//
//            Text(
//                text = "FREE ROBUX HACKS!!!",
//                color = Color.Red,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Bold
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // ─── CTA Button ──────────────────
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(48.dp)
//                    .clip(RoundedCornerShape(50))
//                    .background(Color.White),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Get Now",
//                    color = Color.Black,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    device = Devices.PIXEL_6
)
@Composable
fun FakeAdCardPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Black)
            .padding(16.dp)
    ) {
        FakeAdCard()
    }
}
