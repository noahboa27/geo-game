package com.example.geogame.flag_game.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.geogame.flag_game.domain.data.FlagGameCountry
import com.example.geogame.flag_game.presentation.viewModel.FlagGameViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FlagGameScreen(
    onQuitClicked: () -> Unit,
    onGameOver: (finalScore: Int) -> Unit,
    viewModel: FlagGameViewModel = koinViewModel()
) {
    val state = viewModel.flagGameState.collectAsStateWithLifecycle()
    if (state.value.isLoading.not()) {
        if (state.value.isGameOver) {
            onGameOver(state.value.score)
        }

        val currentQuestion = state.value.currentQuestion
        val answer = state.value.currentAnswer

        FlagGameContent(
            isLoading = state.value.isLoading,
            progression = state.value.progression[state.value.currentQuestionNumber - 1],
            currentQuestionNumber = state.value.currentQuestionNumber,
            totalQuestionSets = state.value.numberOfQuestions,
            currentQuestion = currentQuestion,
            flagUrl = answer.flagUrl,
            // onDoneLoading = { viewModel.doneLoading() },
            onQuitClicked = onQuitClicked,
            onAnswerClicked = { viewModel.processAnswer(it) }
        )
    }
}

@Composable
fun FlagGameContent(
    isLoading: Boolean,
    progression: Float,
    currentQuestionNumber: Int,
    totalQuestionSets: Int,
    currentQuestion: List<FlagGameCountry>,
    flagUrl: String,
    // onDoneLoading: () -> Unit,
    onQuitClicked: () -> Unit,
    onAnswerClicked: (Boolean) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            shape = RoundedCornerShape(percent = 50),
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.End),
            onClick = { onQuitClicked() }
        ) {
            Text(text = "Quit")
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(flagUrl)
                .build(),
            contentDescription = "Country Flag",
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )
//        Image(
//            //FIXME don't use fixed drawable
//            painter = painterResource(id = R.drawable.united_states_flag),
//            contentDescription = "Country Flag",
//            modifier = Modifier
//                .constrainAs(flagImage) {
//                    top.linkTo(flagImageGuideline)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//        )

        Box(
            modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            // top left
            Button(
                shape = RoundedCornerShape(percent = 20),
                modifier = Modifier
                    .fillMaxHeight(0.48f)
                    .fillMaxWidth(0.48f)
                    .align(Alignment.TopStart),
                onClick = {
                    onAnswerClicked(currentQuestion[0].isAnswer)
                }
            ) {
                Text(
                    text = currentQuestion[0].name,
                    textAlign = TextAlign.Center
                )
            }

            // top right
            Button(
                shape = RoundedCornerShape(percent = 20),
                modifier = Modifier
                    .fillMaxHeight(0.48f)
                    .fillMaxWidth(0.48f)
                    .align(Alignment.TopEnd),
                onClick = {
                    onAnswerClicked(currentQuestion[1].isAnswer)
                }
            ) {
                Text(
                    text = currentQuestion[1].name,
                    textAlign = TextAlign.Center
                )
            }

            // bottom left
            Button(
                shape = RoundedCornerShape(percent = 20),
                modifier = Modifier
                    .fillMaxHeight(0.48f)
                    .fillMaxWidth(0.48f)
                    .align(Alignment.BottomStart),
                onClick = {
                    onAnswerClicked(currentQuestion[2].isAnswer)
                }
            ) {
                Text(
                    text = currentQuestion[2].name,
                    textAlign = TextAlign.Center
                )
            }

            // bottom right
            Button(
                shape = RoundedCornerShape(percent = 20),
                modifier = Modifier
                    .fillMaxHeight(0.48f)
                    .fillMaxWidth(0.48f)
                    .align(Alignment.BottomEnd),
                onClick = {
                    onAnswerClicked(currentQuestion[3].isAnswer)
                }
            ) {
                Text(
                    text = currentQuestion[3].name,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.weight(0.17f))

        LinearProgressIndicator(
            progress = progression,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "$currentQuestionNumber / $totalQuestionSets",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        )

        Spacer(modifier = Modifier.weight(0.03f))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFlagGameContent() {
    FlagGameContent(
        isLoading = false,
        onQuitClicked = {},
        onAnswerClicked = {},
        // onDoneLoading = {},
        currentQuestionNumber = 4,
        progression = 0.4.toFloat(),
        totalQuestionSets = 10,
        currentQuestion = listOf(
            FlagGameCountry("", "USA", false),
            FlagGameCountry("", "Canada", false),
            FlagGameCountry("", "France", false),
            FlagGameCountry("", "Mexico", false)
        ),
        flagUrl = ""
    )
}