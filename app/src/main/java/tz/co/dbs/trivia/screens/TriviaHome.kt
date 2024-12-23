package tz.co.dbs.trivia.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import tz.co.dbs.trivia.component.TriviaQuestion

@Composable
fun TriviaHome(
    modifier: Modifier = Modifier,
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    TriviaQuestion(viewModel)
}
