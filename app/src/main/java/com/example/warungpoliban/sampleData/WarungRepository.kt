package com.example.warungpoliban.sampleData

import com.example.warungpoliban.R
import com.example.warungpoliban.data.DataListWarung

// Model untuk representasi data warung
//data class DataWarung(
//    val listWarung: List<DataListWarung>
//)
//
//// data yang ingin isi ke dalam listWarung
//val dataListWarung = listOf(
//    DataListWarung(1,"Warung Ibu Tuti", "Wilayah A", R.drawable.warung_a),
//    DataListWarung(2,"Warung Ibu Jannah", "Wilayah B", R.drawable.warung_b)
//)
//
//// Penggunaan model DataWarung dengan list data dataListWarung
//val dataWarung = DataWarung(listWarung = dataListWarung)

object WarungRepository {
    val daftarWarung = listOf(
        DataListWarung(1, "Warung A", "Wilayah X", R.drawable.warung_a),
        DataListWarung(2, "Warung B", "Wilayah Y", R.drawable.warung_b),
        DataListWarung(3, "Warung C", "Wilayah Z", R.drawable.warung_c)
    )
}

// cara agar bg wilayah berwarna jadi di setiap data dipasang nama variabel color yg sesuai
// sebelum itu inisialisasi dahulu setiap variabel color sebelum dipanggil