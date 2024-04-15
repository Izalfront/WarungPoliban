package com.example.warungpoliban.listCard


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

data class DataListWarung (
    val id : Int,
    val namaWarung : String,
    val wilayah : String,
    val textColor : Color,
    val bgColor : Color,
    val image : Int
)

object Coloring{
    val RedTextBg = Color(0xFFFFD3D3)
    val RedText = Color(0xFFEE4040)

    val YellowTextBg = Color(0xFFFFF8D3)
    val YellowText = Color(0xFFA98B1D)

    val BlueTextBg = Color(0xFFD3E2FF)
    val BlueText = Color(0xFF1D44A9)

    val PurpleTextBg = Color(0xFFF6D3FF)
    val PurpleText = Color(0xFF8630BB)

    val OrangeTextBg = Color(0xFFFEC8AA)
    val OrangeText = Color(0xFFA9581D)

    val CyanTextBg = Color(0xFFAAEFFE)
    val CyanText = Color(0xFF1D90A9)

    val PrimaryRed = Color(0xFFEE4040)
}
object WarungRepository {
    val daftarWarung = listOf(
        DataListWarung(1, "Warung A", "Wilayah A",Coloring.RedText,Coloring.RedTextBg, R.drawable.warung_c),
        DataListWarung(2, "Warung B", "Wilayah B",Coloring.YellowText,Coloring.YellowTextBg, R.drawable.warung_b),
        DataListWarung(3, "Warung C", "Wilayah C",Coloring.BlueText,Coloring.BlueTextBg, R.drawable.warung_a),
        DataListWarung(4, "Warung D", "Wilayah D",Coloring.PurpleText,Coloring.PurpleTextBg, R.drawable.warung_d),
        DataListWarung(5, "Warung E", "Wilayah E",Coloring.OrangeText,Coloring.OrangeTextBg, R.drawable.warung_e),
        DataListWarung(6, "Warung F", "Wilayah F",Coloring.CyanText,Coloring.CyanTextBg, R.drawable.warung_f)
    )
}

@Composable
fun WarungItem(warung: DataListWarung, onClick: () -> Unit){
    val arrowDetail = painterResource(id = R.drawable.down_line)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .wrapContentWidth()
                    .clickable(onClick = onClick),
                shape = MaterialTheme.shapes.small,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = warung.image),
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
                    ) {
                        Text(
                            text = warung.namaWarung,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.padding(bottom = 12.dp))
                        Text(
                            modifier = Modifier
                                .background(
//                                    Color.Red.copy(alpha = 0.1f),
                                    warung.bgColor,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                                .clip(shape = RoundedCornerShape(12.dp)),
                            text = warung.wilayah,
                            fontSize = 10.sp,
                            color = warung.textColor
                        )
                        Spacer(modifier = Modifier.padding(bottom = 12.dp))
                        Text(
                            text = "kulkas | meja makan | tisu",
                            fontSize = 10.sp,
                            color = Color.Gray,
                        )
                    }
//            --------- icon detail
                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .padding(8.dp)
                            .graphicsLayer(alpha = 0.5f),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Image(
                            painter = arrowDetail,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

@Composable
fun WarungList() {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LazyColumn {
        items(WarungRepository.daftarWarung) { warung ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                WarungItem(warung = warung) {
                    coroutineScope.launch {
                        // Tampilkan pesan Snackbar
                        snackbarHostState.showSnackbar("Selected: ${warung.namaWarung}")
                    }
                }
            }
        }
    }

    // Menampilkan Snackbar
    SnackbarHost(snackbarHostState)
}

@Preview(showBackground = true)
@Composable
fun PreviewListWarung() {
    WarungList()
}