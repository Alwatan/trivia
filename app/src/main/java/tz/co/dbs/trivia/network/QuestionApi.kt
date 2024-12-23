package tz.co.dbs.trivia.network

import retrofit2.http.GET
import tz.co.dbs.trivia.model.Question
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("questions.json")
    suspend fun getQuestions(): List<Question>
}