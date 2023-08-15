package com.example.geogame.flag_game.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MainMenuContent() {
    Column {
        Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        Text(
            text = "Geo Game",
            fontSize = 65.sp,
            modifier = Modifier.align(CenterHorizontally)
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.02f))
        Text(
            text = "(Pick a mini game to play)",
            fontSize = 18.sp,
            modifier = Modifier.align(CenterHorizontally)
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.35f))
        Button(
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .align(CenterHorizontally)
                .fillMaxWidth(0.6f),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Flag game",
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMainMenuContent() {
    MainMenuContent()
}