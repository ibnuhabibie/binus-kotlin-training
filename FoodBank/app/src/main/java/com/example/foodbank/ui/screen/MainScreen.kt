package com.example.foodbank.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.foodbank.Screen
import com.example.foodbank.ui.viewmodel.FoodBankUIState
import com.example.foodbank.ui.viewmodel.FoodBankViewModel
import com.example.foodbank.ui.widget.FoodBankCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: FoodBankViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Food Bank",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                )
            )
        },

        ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            SearchBar(
                onValueChange = { viewModel.onSearch(it) }
            )

            when (uiState) {
                FoodBankUIState.Loading -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(70.dp),
                            strokeWidth = 2.dp,
                            color = Color.Black
                        )
                    }
                }

                is FoodBankUIState.Success -> {
                    val foodbanks = (uiState as FoodBankUIState.Success).result

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(top = 24.dp)
                    ) {
                        items(
                            count = foodbanks.size,
                            key = {
                                foodbanks[it].slug
                            }
                        ) { item ->
                            FoodBankCard(
                                data = foodbanks[item],
                                onClick = {
                                    println("Card Clicked")
                                    viewModel.onSelect(foodbanks[item])
                                    navController.navigate(Screen.DetailScreen.Route)
                                }
                            )
                        }
                    }
                }

                else -> {
                    val message = (uiState as FoodBankUIState.Error).message
                    Text(message)
                }
            }
        }
    }
}

@Composable
private fun SearchBar(
    onValueChange: (String) -> Unit
) {
    var keyword by remember { mutableStateOf("") }
    println("SearchBar ReRender")

    Box(
        Modifier.background(Color.LightGray)
    ) {
        Column(
            Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            TextField(
                value = keyword,
                onValueChange = {
                    keyword = it
                    onValueChange(it)
                },
                placeholder = {
                    Text("Search by location or name...")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}