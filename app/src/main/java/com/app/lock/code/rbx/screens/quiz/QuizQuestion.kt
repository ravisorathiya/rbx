package com.app.lock.code.rbx.screens.quiz

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctIndex: Int
)
