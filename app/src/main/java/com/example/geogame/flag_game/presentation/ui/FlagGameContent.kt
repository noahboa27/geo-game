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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.geogame.R

@Composable
fun FlagGameContent() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
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
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Quit")
        }

        Image(
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
            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth(0.45f),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Option 1")
            }

            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth(0.45f),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Option 2")
            }

            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth(0.45f),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Option 3")
            }

            Button(
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth(0.45f),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Option 4")
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
    FlagGameContent()
}