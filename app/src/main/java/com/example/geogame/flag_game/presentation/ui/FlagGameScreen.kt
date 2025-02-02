package com.example.geogame.flag_game.presentation.ui

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.geogame.R
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
        val answer = currentQuestion[state.value.answerIndex]

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

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        //FIXME: remove constraints and use spacers with percentages
        val (quitButton, flagImage, answerOptionBox, progressBar, progressText) = createRefs()
        val flagImageGuideline = createGuidelineFromTop(0.2f)
        val answerBoxGuideline = createGuidelineFromTop(0.65f)
        val progressBarGuideline = createGuidelineFromBottom(0.07f)

        Button(
            shape = RoundedCornerShape(percent = 50),
            modifier = Modifier
                .constrainAs(quitButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(10.dp),
            onClick = { onQuitClicked() }
        ) {
            Text(text = "Quit")
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(flagUrl)
                .build(),
            contentDescription = "Country Flag",
            placeholder = painterResource(R.drawable.loading_stub),
            onSuccess = {  },
            modifier = Modifier
                .constrainAs(flagImage) {
                    top.linkTo(flagImageGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
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
                .fillMaxHeight(0.14f)
                .fillMaxWidth(0.75f)
                .constrainAs(answerOptionBox) {
                    top.linkTo(answerBoxGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentAlignment = Alignment.Center
        ) {
            // top left
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth(0.45f),
                onClick = {
                    onAnswerClicked(currentQuestion[0].isAnswer)
                }
            ) {
                Text(text = currentQuestion[0].name)
            }

            // top right
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth(0.45f),
                onClick = {
                    onAnswerClicked(currentQuestion[1].isAnswer)
                }
            ) {
                Text(text = currentQuestion[1].name)
            }

            // bottom left
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth(0.45f),
                onClick = {
                    onAnswerClicked(currentQuestion[2].isAnswer)
                }
            ) {
                Text(text = currentQuestion[2].name)
            }

            // bottom right
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth(0.45f),
                onClick = {
                    onAnswerClicked(currentQuestion[3].isAnswer)
                }
            ) {
                Text(text = currentQuestion[3].name)
            }
        }

        LinearProgressIndicator(
            progress = progression,
            modifier = Modifier
                .constrainAs(progressBar) {
                    top.linkTo(progressBarGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "$currentQuestionNumber / $totalQuestionSets",
            modifier = Modifier
                .constrainAs(progressText) {
                    top.linkTo(progressBar.bottom, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
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