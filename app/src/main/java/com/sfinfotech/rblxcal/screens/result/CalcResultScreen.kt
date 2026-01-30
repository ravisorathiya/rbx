package com.sfinfotech.rblxcal.screens.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sfinfotech.rblxcal.R
import com.sfinfotech.rblxcal.model.CalcType
import com.sfinfotech.rblxcal.util.Util
import com.sfinfotech.rblxcal.util.Util.calculate

@Composable
fun CalcResultScreen(
    type: CalcType,
    onBack: () -> Unit
) {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0.0") }

    val title = when (type) {
        CalcType.USD_TO_RBX -> "USD to RBX"
        CalcType.RBX_TO_USD -> "RBX to USD"
        CalcType.RBX_TO_DOLLAR -> "RBX to Dollar"
        CalcType.DOLLAR_TO_RBX -> "Dollar to RBX"
        CalcType.BC_TO_RBX -> "BC to RBX"
        CalcType.TBC_TO_RBX -> "TBC to RBX"
        CalcType.OBC_TO_RBX -> "OBC to RBX"
        else -> ""
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .systemBarsPadding()
    ) {

        // 🔹 MAIN CONTENT
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .padding(bottom = 160.dp) // space for ad
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Default.ArrowBack, null, tint = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(title, color = Color.White, style = MaterialTheme.typography.titleLarge)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Enter Amount", color = Color.White)

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = input,
                onValueChange = { input = it.filter { c -> c.isDigit() || c == '.' } },
                placeholder = { Text("Enter your Amount") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    val number = input.toDoubleOrNull() ?: 0.0
                    result = calculate(type, number).toString()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Util.PRIMARY__COLOR)
            ) {
                Text("Convert", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1E)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Converted Amount", color = Color.LightGray)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "$result",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = onBack,
                        colors = ButtonDefaults.buttonColors(containerColor = Util.PRIMARY__COLOR)
                    ) {
                        Text("Done", color = Color.Black)
                    }
                }
            }
        }

        // 🔹 BOTTOM AD (Pinned)
        Image(
            painter = painterResource(R.drawable.ad),
            contentDescription = "Ad",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .wrapContentHeight()
//                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPrevoew() {
    CalcResultScreen(
        type = CalcType.OBC_TO_RBX,
        onBack = {  }
    )
}