package com.example.warungpoliban.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.warungpoliban.R
import com.example.warungpoliban.listCard.WarungList


@Composable
fun mapWarung() {
    val painter: Painter = painterResource(R.drawable.peta)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            modifier = Modifier.size(390.dp),
            contentDescription = null
        )
    }
}

@Composable
fun listNamaWarung(){
    Column ( modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = "List Warung Poliban",
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        )
    }
}

@Composable
fun Home(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
            .background(Color.White)
    ){
        mapWarung()
        listNamaWarung()
        Spacer(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
//        listwarung ini yg akan di looping
        WarungList()
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHome(){
    Home()
}