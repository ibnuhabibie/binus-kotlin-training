package com.example.learnkotlin.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.learnkotlin.R

@Composable
fun ProfileCardBasic() {
    Card(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.surja_raj),
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp)),
                contentDescription = "profile picture",
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Surja Raj",
                    style = MaterialTheme.typography.displayMedium
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "UI/UX Desinger who focuses on simplicity & usability.",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 22.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text("View Stats")
                }
            }
        }
    }
}