package com.example.geogame.flag_game.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.geogame.R

@Composable
fun FlagGameContent() {
    Column {
        Button(
            modifier = Modifier.align(Alignment.End),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Quit")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.united_states_flag),
            contentDescription = "US Flag"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxHeight(0.18f)
                .fillMaxWidth(0.5f),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(text = "Option 1")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Text(text = "Option 2")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text(text = "Option 3")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Text(text = "Option 4")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFlagGameContent() {
    FlagGameContent()
}