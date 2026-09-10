package com.example.foodbank.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodbank.R
import com.example.foodbank.model.Foodbank

@Composable
fun FoodBankCard(
    data: Foodbank,
    onClick: () -> Unit
) {
    Column(Modifier.padding(horizontal = 24.dp)) {
        Card(
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(12.dp)
                    .height(
                        IntrinsicSize.Min
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp),
                    contentDescription = ""
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize(),

                    ) {
                    Column() {
                        Text(
                            text = data.name,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(data.network ?: "-")
                    }
                    Text(data.address ?: "-")
                }
            }
        }
    }
}