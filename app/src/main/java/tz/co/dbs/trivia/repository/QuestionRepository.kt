package tz.co.dbs.trivia.repository

import android.util.Log
import tz.co.dbs.trivia.data.DataOrException
import tz.co.dbs.trivia.model.Question
import tz.co.dbs.trivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val TAG = "QuestionRepository"

    private val dataOrException = DataOrException<List<Question>, Boolean, Exception>()

    suspend fun getQuestions(): DataOrException<List<Question>, Boolean, Exception> {
        dataOrException.isLoading = true
        try {
            dataOrException.data = api.getQuestions()
        } catch (e: Exception) {
            dataOrException.exception = e
            Log.d(TAG, "getQuestions: ${e.message}")
        } finally {
            dataOrException.isLoading = false
        }
        return dataOrException
    }

}