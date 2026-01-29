package com.app.lock.code.rbx.core.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lock.code.rbx.R
import com.app.lock.code.rbx.util.Util
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: () -> Unit) {

    val alphaAnim = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        alphaAnim.animateTo(1f, animationSpec = tween(800))
        delay(3500) // total ≈ 3 sec
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // 🔹 Logo
            Image(
                painter = painterResource(R.drawable.app_logo), // use your green hex logo
                contentDescription = "Logo",
                modifier = Modifier
                    .size(140.dp)
                    .alpha(alphaAnim.value)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                "RBX",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = Util.PRIMARY__COLOR,
                modifier = Modifier.alpha(alphaAnim.value)
            )

            Text(
                "CALCULATOR",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Util.PRIMARY__COLOR,
                letterSpacing = 2.sp,
                modifier = Modifier.alpha(alphaAnim.value)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "ROBLOX COUNTER",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f),
                letterSpacing = 4.sp,
                modifier = Modifier.alpha(alphaAnim.value)
            )
        }

        // 🔹 Bottom progress bar
        LinearProgressIndicator(
            color = Util.PRIMARY__COLOR,
            trackColor = Color.DarkGray,
            modifier = Modifier
                .padding(all = 32.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(4.dp)
        )
    }
}
