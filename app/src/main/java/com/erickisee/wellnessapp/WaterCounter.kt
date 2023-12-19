package com.erickisee.wellnessapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun StatefulCounter (modifier: Modifier = Modifier){

    var count by rememberSaveable {mutableStateOf(0)}
    StatelessCounter(modifier, count, onIncrement = {count++})
}

@Composable
private fun StatelessCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement:()->Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(
                text = "You've had $count glasses of water"
            )
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add One")
        }
    }
}