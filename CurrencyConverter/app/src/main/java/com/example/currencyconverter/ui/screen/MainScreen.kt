package com.example.currencyconverter.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.currencyconverter.core.service.CurrencyAPI
import com.example.currencyconverter.model.ConversionResult
import com.example.currencyconverter.ui.viewmodel.ConvertUiState
import com.example.currencyconverter.ui.viewmodel.CurrencyViewModel
import com.example.currencyconverter.ui.widget.BasicDropdown
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: CurrencyViewModel = viewModel()
) {
    var currencies = listOf<String>("USD", "EUR", "IDR")

//    var amount by remember { mutableStateOf("") }
//    var fromCurrency by remember { mutableStateOf("") }
//    var toCurrency by remember { mutableStateOf("") }

    val amount by viewModel.amountInput.collectAsStateWithLifecycle()
    val fromCurrency by viewModel.fromCurrency.collectAsStateWithLifecycle()
    val toCurrency by viewModel.toCurrency.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


//    var currencyResult by remember { mutableStateOf(0.0) }
//    var rateResult by remember { mutableStateOf(0.0) }
//    var isConverting by remember { mutableStateOf(false) }

//    val scope = rememberCoroutineScope()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            Card() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)

                ) {
                    Text(
                        text = "Currency Converter",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.headlineMedium
                    )
                    OutlinedTextField(
                        value = amount,
                        onValueChange = { viewModel.onAmountChanged(it) },
                        label = {
                            Text("Amount")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BasicDropdown(
                            label = "From",
                            currencies = currencies,
                            selectedCurrency = fromCurrency,
                            onValueChanged = {
                                viewModel.onFromCurrencyChanged(it)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        BasicDropdown(
                            label = "To",
                            currencies = currencies,
                            selectedCurrency = toCurrency,
                            onValueChanged = {
                                viewModel.onToCurrencyChanged(it)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    Button(
                        onClick = { viewModel.convertCurrency() },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black
                        ),
                        contentPadding = PaddingValues(vertical = 22.dp)
                    ) {
                        if (uiState == ConvertUiState.Loading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                strokeWidth = 2.dp,
                                color = Color.White
                            )
                        } else {
                            Text(
                                text = "Convert",
                                color = Color.White
                            )
                        }

                    }
                }
            }
        }
        if (uiState is ConvertUiState.Success) {
            val response: ConversionResult = (uiState as ConvertUiState.Success).result

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {
                        Text(
                            text = "${response.result} $toCurrency",
                            style = MaterialTheme.typography.displaySmall,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Exchange Rate: 1 $fromCurrency = ${response.rate} $toCurrency",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }

    }
}

