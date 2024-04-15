package com.example.warungpoliban.detailHalaman

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ListItem(
    val id: Int,
    val namaMakanan: String,
    val textColor: Color,
    val bgColor: Color,
    val textSecon : Color
)

object ColorCategoryList {
    val PrimaryRed = Color(0xFFEE4040)
    val SecondaryColor = Color(0xFFECECEC)
    val SecondaryText = Color(0xFF565656)
}

object ListRepository {
    val kategori = listOf(
        ListItem(
            1,
            "Makanan",
            ColorCategoryList.SecondaryColor,
            ColorCategoryList.PrimaryRed,
            ColorCategoryList.SecondaryText
        ),
        ListItem(
            2,
            "Minuman",
            ColorCategoryList.SecondaryColor,
            ColorCategoryList.PrimaryRed,
            ColorCategoryList.SecondaryText
        ),
        ListItem(
            3,
            "Wadai",
            ColorCategoryList.SecondaryColor,
            ColorCategoryList.PrimaryRed,
            ColorCategoryList.SecondaryText
        ),
    )
}

@Composable
fun ItemCategory(item: ListItem, onItemClick: (ListItem) -> Unit) {
    var isSelected by remember { mutableStateOf(false) }

    val textColor = if (isSelected) item.textColor else item.textSecon
    val bgColor = if (isSelected) Color.Red else item.textColor

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable {
                isSelected = !isSelected
                onItemClick(item)
            }
    ) {
        Text(
            text = item.namaMakanan,
            fontSize = 12.sp,
            color = textColor,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            modifier = Modifier
                .background(bgColor, shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 26.dp, vertical = 11.dp)
                .clip(shape = RoundedCornerShape(12.dp))
        )
    }
}

@Composable
fun ListCategory() {
    val items = ListRepository.kategori
    val selectedListItem = remember { mutableStateOf<ListItem?>(null) }

    LazyRow {
        items(items) { item ->
            ItemCategory(item = item) {
                selectedListItem.value = it
                // Handle item selection here if needed
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory() {
    ListCategory()
}

