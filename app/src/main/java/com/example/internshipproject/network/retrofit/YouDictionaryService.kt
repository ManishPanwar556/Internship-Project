package com.example.internshipproject.network.retrofit

import com.example.internshipproject.network.response.get.WordData
import retrofit2.Response
import retrofit2.http.GET


interface YouDictionaryService {

   /** function to get a new word from api**/

    @GET("bolo/feed.json")
    suspend fun getWord():Response<WordData>
}