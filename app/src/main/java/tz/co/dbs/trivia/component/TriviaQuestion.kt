package tz.co.dbs.trivia.component

import android.util.Log
import androidx.compose.runtime.Composable
import tz.co.dbs.trivia.screens.QuestionsViewModel

private const val TAG = "QuestionComponent"

@Composable
fun TriviaQuestion(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    Log.d(TAG, "QuestionComponent: ${questions?.size}")
}