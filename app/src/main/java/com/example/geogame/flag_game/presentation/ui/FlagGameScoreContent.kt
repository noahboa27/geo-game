package com.example.geogame.flag_game.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.geogame.flag_game.presentation.state.FlagGameState

@Composable
fun FlagGameScoreScreen(
    onMainMenuClicked: () -> Unit,
    flagGameScore: Int
) {
    FlagGameScoreContent(
        finalScore = flagGameScore,
        onMainMenuClicked
    )
}

@Composable
fun FlagGameScoreContent(
    finalScore: Int,
    onMainMenuClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxHeight(0.15f))
        Text(
            text = "Final Score",
            fontSize = 60.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        Text(
            text = "${finalScore}/10",
            fontSize = 50.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.5f))
        Button(
            shape = RoundedCornerShape(percent = 50),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { onMainMenuClicked() }
        ) {
            Text(
                text = "Main Menu"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFlagGameScoreContent() {
    FlagGameScoreContent(
        finalScore = 7,
        onMainMenuClicked = {}
    )
}