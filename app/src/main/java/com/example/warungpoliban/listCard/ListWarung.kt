package com.example.warungpoliban.listCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.warungpoliban.R

@Preview(showBackground = true)
@Composable
fun listWarung(){
    val warungA = painterResource(id = R.drawable.warung_a)
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .wrapContentWidth()
            .clickable { },
                colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.04f),
    )
    ){
        Row(
        ) {
            Image(
                painter = warungA,
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .fillMaxSize()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
            )
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "Warung Nasi Ibu Tuti",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.padding(bottom = 12.dp))
                Text(text = "Wilayah A")
                Spacer(modifier = Modifier.padding(bottom = 18.dp))
                Text(
                    text = "kulkas | meja makan | tisu",
                    fontSize = 12.sp
                )
            }
            Column(
                modifier = Modifier
                    .offset(x = (18).dp, y = (82).dp)
            ) {
                    Text(
                        modifier = Modifier
                            .background(Color.Red, shape = RoundedCornerShape(6.dp))
                            .padding(horizontal = 18.dp, vertical = 6.dp),
                        text = "Detail",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                    )
            }
        }
    }
}
