package kldemo.mvvmcomposehiltexample.data.core

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kldemo.mvvmcomposehiltexample.R
import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails
import kotlinx.coroutines.delay

class MockApiService(private val appContext: Context) : Api {

    override suspend fun getProgrammingLanguages(): List<ProgrammingLanguage> {
        delay(1000)//emulate network latency
        val responseString: String =
            appContext.resources.openRawResource(R.raw.programming_languages).bufferedReader()
                .use { it.readText() }
        return Gson().fromJson(
            responseString,
            object : TypeToken<List<ProgrammingLanguage>>() {}.type
        )
    }

    override suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails {
        delay(1000)//emulate network latency
        val responseString: String = when (name) {
            "Kotlin" -> appContext.resources.openRawResource(R.raw.kotlin_details).bufferedReader()
                .use { it.readText() }

            else -> appContext.resources.openRawResource(R.raw.java_details).bufferedReader()
                .use { it.readText() }
        }
        return Gson().fromJson(responseString, ProgrammingLanguageDetails::class.java)
    }
}