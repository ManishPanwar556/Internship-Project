package com.example.internshipproject.network.response.get



data class WordDay(
    val anotonyms: List<String>,
    val generic: String,
    val header: String,
    val synonym: List<String>,
    val word: String
)