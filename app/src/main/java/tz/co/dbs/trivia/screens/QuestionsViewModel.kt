package tz.co.dbs.trivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tz.co.dbs.trivia.data.DataOrException
import tz.co.dbs.trivia.model.Question
import tz.co.dbs.trivia.repository.QuestionRepository
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {

    val data: MutableState<DataOrException<List<Question>, Boolean, Exception>>
            = mutableStateOf(DataOrException(null, false, null))

    init {
        getQuestions()
    }

    private fun getQuestions(){
        viewModelScope.launch {
            data.value = repository.getQuestions()
        }
    }
}