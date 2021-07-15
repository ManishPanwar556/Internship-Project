package com.example.internshipproject.repository

import com.example.internshipproject.network.response.get.WordData
import com.example.internshipproject.network.retrofit.YouDictionaryClient
import com.example.internshipproject.utils.Result
import com.example.internshipproject.utils.Status

class YourDictionaryRepository {

    private val service = YouDictionaryClient.getService()

    suspend fun getNewWord(): Result<WordData> {
        return try {
            val res = service.getWord()
            if (res.isSuccessful) {
                if (res.body() != null) {
                    Result(Status.SUCCESS, res.body(), "Success")
                } else {
                    Result(Status.ERROR, null, "Response body is null")
                }
            } else {
                Result(Status.ERROR, null, "Unsuccessful attempt")
            }

        } catch (e: Exception) {
            Result(Status.ERROR, null, e.message)
        }
    }

}