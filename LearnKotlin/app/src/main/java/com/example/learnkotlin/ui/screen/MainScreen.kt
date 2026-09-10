package com.example.learnkotlin.ui.screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learnkotlin.Screen
import com.example.learnkotlin.ui.widget.ExitDialog

@Composable
fun MainScreen(
    navController: NavController
) {
    val activity = LocalActivity.current

    var text by remember {
        mutableStateOf("Ibnu Habibie")
    }

    var showDialog by remember { mutableStateOf(false) }

    BackHandler(
        enabled = !showDialog
    ) {
        Log.d("LearnKotlin", "On Back Handler")
        showDialog = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            text, onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate(Screen.DetailScreen.route + "/${text}")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Click")
        }
    }

    if (showDialog) {
        ExitDialog(
            onDismiss = { showDialog = false },
            onConfirm = {
                showDialog = false
                activity?.finish()
            }
        )
    }
}