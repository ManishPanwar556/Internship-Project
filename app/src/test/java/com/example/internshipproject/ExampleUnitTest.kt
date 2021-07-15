package com.example.internshipproject

import com.example.internshipproject.network.retrofit.YouDictionaryClient
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_api(){
        runBlocking {
            val res= YouDictionaryClient.getService().getWord()
            assertNotNull(res.body())
        }
    }
}