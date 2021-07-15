package com.example.internshipproject.network.retrofit

import com.example.internshipproject.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object YouDictionaryClient {

    /** function to get the YouDictionaryService interface to make get or post requests **/

    fun getService(): YouDictionaryService {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL).build().create(YouDictionaryService::class.java)
    }


}