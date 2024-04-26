package com.example.geogame.main_menu.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.geogame.main_menu.presentation.intent.MainMenuIntent
import com.example.geogame.main_menu.presentation.viewModel.MainMenuViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MainMenuScreen() {
    val viewModel: MainMenuViewModel = getViewModel()
    // val state = viewModel.mainMenuState.collectAsStateWithLifecycle()

    MainMenuContent {
        viewModel.processIntent(it)
    }
}

@Composable
fun MainMenuContent(
    onIntent: (MainMenuIntent) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
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
            onClick = { onIntent(MainMenuIntent.StartFlagGame) }
        ) {
            Text(
                text = "Flag game",
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainMenuContent() {
    MainMenuContent{}
}