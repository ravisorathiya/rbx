package com.sfinfotech.rblxcal.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sfinfotech.rblxcal.R
import com.sfinfotech.rblxcal.util.Util.rememberIsNetworkAvailable

@Composable
fun NoInternetDialog() {
    val context = LocalContext.current
    val isOnline by rememberIsNetworkAvailable()

    if (!isOnline) {
        Dialog(onDismissRequest = {}) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF1C1C1E))
                    .padding(24.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(
                        painter = painterResource(R.drawable.ic_no_internet),
                        contentDescription = null,
                        modifier = Modifier.size(70.dp)
                    )

                    Spacer(Modifier.height(16.dp))

                    Text(
                        "No Internet Connection",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Please enable WiFi or Mobile Data",
                        color = Color.LightGray,
                        textAlign = TextAlign.Center
                    )

                    Spacer(Modifier.height(24.dp))

                    Button(
                        onClick = { Util.openNetworkSettings(context) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Util.PRIMARY__COLOR
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Open Network Settings", color = Color.Black)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun NoInternetDialogPreview() {
    NoInternetDialog()
}