package com.example.warungpoliban.detailHalaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.warungpoliban.R

data class DataListMakanan (
    val id : Int,
    val namaMakanan : String,
    val namaWarung : String,
    val namaLauk : String,
    val harga : String,
    val textColor : Color,
    val bgColor : Color,
    val image : Int
)

object ColorCategory{
    val PrimaryRed = Color(0xFFEE4040)
    val SecondaryColor = Color(0xFFF4F4F4)
}

object MakananRepository{
    val daftarMakanan = listOf(
        DataListMakanan(
            1,
            "Nasi Goreng",
            "Warung A",
            "Ayam | Telor",
            "Rp 8.000",
            ColorCategory.SecondaryColor,
            ColorCategory.PrimaryRed,
            R.drawable.nasi_goreng
        ),
        DataListMakanan(
            2,
            "Nasi Geprek",
            "Warung A",
            "Ayam",
            "Rp 10.000",
            ColorCategory.SecondaryColor,
            ColorCategory.PrimaryRed,
            R.drawable.ayam_geprek
        ),
        DataListMakanan(
            3,
            "Nasi Lalapan",
            "Warung A",
            "Ayam",
            "Rp 10.000",
            ColorCategory.SecondaryColor,
            ColorCategory.PrimaryRed,
            R.drawable.nasi_lalapan
        ),
        DataListMakanan(
            4,
            "Nasi Rawon",
            "Warung B",
            "Sapi",
            "Rp 12.000",
            ColorCategory.SecondaryColor,
            ColorCategory.PrimaryRed,
            R.drawable.nasi_rawon
        ),
    )
}

@Composable
fun HalamanDetail(makanan : DataListMakanan){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .wrapContentWidth(),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = makanan.image),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .fillMaxSize()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
            )
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(start = 8.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = makanan.namaMakanan,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = makanan.namaWarung,
                    fontSize = 10.sp,
                    color = Color.Gray,
                )
                Spacer(modifier = Modifier.padding(bottom = 12.dp),)
                Row (modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(
                        modifier = Modifier
                            .background(
                                makanan.bgColor,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                            .clip(shape = RoundedCornerShape(12.dp)),
                        text = makanan.namaLauk,
                        fontSize = 10.sp,
                        color = makanan.textColor
                    )
                    Text(modifier = Modifier.padding(end = 16.dp),
                        text = makanan.harga,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
fun MakananList() {
    LazyColumn {
        items(MakananRepository.daftarMakanan) { makanan ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                HalamanDetail(makanan = makanan)
            }
        }
    }
}



// Gambar Warung Detail
@Composable
fun ImageWarung(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagewarung_a),
            contentDescription = null,
            modifier = Modifier.padding(14.dp)
        )
    }
}

@Composable
fun DetailHalaman(navController: NavController? = null){
    Column {
        ImageWarung()
        ListCategory()
        Spacer(modifier = Modifier.padding(vertical = 6.dp))
        MakananList()
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewListMakanan(){
    DetailHalaman()
}