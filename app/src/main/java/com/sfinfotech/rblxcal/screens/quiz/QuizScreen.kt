package com.sfinfotech.rblxcal.screens.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sfinfotech.rblxcal.screens.quiz.composables.QuizOption
import com.sfinfotech.rblxcal.screens.spin.composables.SpinHeader
import com.sfinfotech.rblxcal.util.Util

@Composable
fun QuizScreen(
    onQuizFinished: (score: Int) -> Unit,
    onBackClick: () -> Unit

) {
    val questions = remember { QuizRepository.getRandomQuiz() }
    var currentIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }

    val question = questions[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        SpinHeader(
            balance = 472, onBackClick = onBackClick,
            title = "Quiz Time",
            showWaller = false

        )

        Spacer(Modifier.height(20.dp))

        // Question Count Bar
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(Util.PRIMARY__COLOR, RoundedCornerShape(20.dp))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Question ${currentIndex + 1} / 10", fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(24.dp))

        Text(
            modifier = Modifier.padding(16.dp),
            text = question.question,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 24.dp)
        ) {
            itemsIndexed(question.options) { index, option ->
                QuizOption(option) {
                    if (index == question.correctIndex) score++

                    if (currentIndex < 9) {
                        currentIndex++
                    } else {
                        onQuizFinished(score)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen(
        onQuizFinished = {  },
        onBackClick = {}
    )
}
