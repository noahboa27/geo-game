package com.example.geogame.flag_game.presentation.ui

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.geogame.R
import com.example.geogame.core.domain.model.FlagGameCountry
import com.example.geogame.core.domain.model.Name
import com.example.geogame.flag_game.domain.data.QuestionSet
import com.example.geogame.flag_game.presentation.intent.FlagGameIntent
import com.example.geogame.flag_game.presentation.viewModel.FlagGameViewModel

@Composable
fun FlagGameScreen(
    navController: NavController,
    viewModel: FlagGameViewModel = viewModel()
) {
    val state = viewModel.flagGameState.collectAsStateWithLifecycle()
    val isLoading = state.value.isLoading
    val currentQuestion by rememberSaveable {
        mutableStateOf(state.value.currentQuestionSet)
    }

    FlagGameContent(isLoading, currentQuestion) {
        viewModel.processIntent(it)
    }
}

@Composable
fun FlagGameContent(
    isLoading: Boolean,
    questionSet: QuestionSet,
    onIntent: (FlagGameIntent) -> Unit
) {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        // remove constraints and use spacers with percentages
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
            onClick = { onIntent(FlagGameIntent.QuitClicked) }
        ) {
            Text(text = "Quit")
        }

        Image(
            //FIXME don't use fixed drawable
            painter = painterResource(id = R.drawable.united_states_flag),
            contentDescription = "US Flag",
            modifier = Modifier
                .constrainAs(flagImage) {
                    top.linkTo(flagImageGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

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
                    onIntent(
                        FlagGameIntent.AnswerSelected(
                            questionSet.options[0]
                        )
                    )
                }
            ) {
                Text(text = questionSet.options[0].name.common)
            }

            // top right
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth(0.45f),
                onClick = {
                    onIntent(
                        FlagGameIntent.AnswerSelected(
                            questionSet.options[1]
                        )
                    )
                }
            ) {
                Text(text = questionSet.options[1].name.common)
            }

            // bottom left
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth(0.45f),
                onClick = {
                    onIntent(
                        FlagGameIntent.AnswerSelected(
                            questionSet.options[2]
                        )
                    )
                }
            ) {
                Text(text = questionSet.options[2].name.common)
            }

            // bottom right
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth(0.45f),
                onClick = {
                    onIntent(
                        FlagGameIntent.AnswerSelected(
                            questionSet.options[3]
                        )
                    )
                }
            ) {
                Text(text = questionSet.options[3].name.common)
            }
        }

        LinearProgressIndicator(
            progress = 0.4f,
            modifier = Modifier
                .constrainAs(progressBar) {
                    top.linkTo(progressBarGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "4 / 10",
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
        questionSet = QuestionSet(
            options = listOf(
                FlagGameCountry("", Name(common = "USA")),
                FlagGameCountry("", Name(common = "Canada")),
                FlagGameCountry("", Name(common = "France")),
                FlagGameCountry("", Name(common = "Mexico"))
            )
        ),
        onIntent = {}
    )
}