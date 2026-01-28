package com.app.lock.code.rbx.screens.quiz

object QuizRepository {

    private val allQuestions = listOf(
        QuizQuestion(
            "Which tool lets you organize objects in Roblox Studio?",
            listOf("Terrain Editor", "Explorer", "Properties", "Toolbox"),
            1
        ),
        QuizQuestion(
            "What language does Roblox use for scripting?",
            listOf("Java", "Lua", "Python", "C#"),
            1
        ),
        QuizQuestion(
            "Which panel edits object values?",
            listOf("Explorer", "Toolbox", "Properties", "Output"),
            2
        ),
        QuizQuestion(
            "What does 'Anchored' do?",
            listOf("Changes color", "Prevents movement", "Adds script", "Deletes object"),
            1
        ),
        QuizQuestion(
            "Which service handles lighting?",
            listOf("Workspace", "Lighting", "ServerStorage", "ReplicatedStorage"),
            1
        ),
        QuizQuestion(
            "Where do scripts run?",
            listOf("Server", "Client", "Both", "Explorer"),
            2
        ),
        QuizQuestion(
            "Which tool imports models?",
            listOf("Explorer", "Toolbox", "Terrain", "Lighting"),
            1
        ),
        QuizQuestion(
            "Which property changes part color?",
            listOf("Material", "Color", "Texture", "Reflectance"),
            1
        ),
        QuizQuestion(
            "Which service stores server-only objects?",
            listOf("ReplicatedStorage", "ServerStorage", "Workspace", "StarterGui"),
            1
        ),
        QuizQuestion(
            "Which object runs code?",
            listOf("Part", "Script", "Model", "Mesh"),
            1
        )
    )

    fun getRandomQuiz(): List<QuizQuestion> =
        allQuestions.shuffled().take(10)
}
