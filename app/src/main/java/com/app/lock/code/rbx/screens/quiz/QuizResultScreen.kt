package com.app.lock.code.rbx.screens.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lock.code.rbx.screens.spin.composables.SpinHeader

@Composable
fun QuizResultScreen(
    score: Int,
    onAddToWallet: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    val reward = score * 10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpinHeader(title = "Quiz Result", balance = 472, onBackClick = onBackClick,showWaller = false)

        Spacer(Modifier.height(30.dp))

        Text("Congrats", fontSize = 42.sp, color = Color(0xFFFFD700))

        Spacer(Modifier.height(10.dp))

        Text("You got $score correct!", color = Color.White)

        Spacer(Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .background(Color(0xFF1C1C1E), RoundedCornerShape(20.dp))
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("You've won ", color = Color.White)
                Text("$reward", color = Color(0xFF5BC58C), fontWeight = FontWeight.Bold)
            }
        }

        Spacer(Modifier.height(30.dp))

        Button(
            onClick = { onAddToWallet(reward) },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5BC58C)),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text("Add to Wallet", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizResultPreview() {
    QuizResultScreen(
        score = 7,
        onAddToWallet = {  }
    ) {}
}
