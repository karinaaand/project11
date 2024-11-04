package com.example.project11

// Data class untuk merepresentasikan objek bencana dengan nama dan tipe bencana
data class Disaster(
    val nameDisaster: String = "",  // Nama bencana
    val disasterType: String = ""    // Tipe bencana (misal: Natural, Man-made)
) {
    // Fungsi untuk mendapatkan drawable (gambar) sesuai nama bencana
    fun getDisasterDrawable(): Int {
        return when (nameDisaster) {
            "Tsunami" -> R.drawable.tsunami  // Mengembalikan ID drawable untuk tsunami
            "Flood" -> R.drawable.flood  // Mengembalikan ID drawable untuk banjir
            "Earthquake" -> R.drawable.earthquake  // Mengembalikan ID drawable untuk gempa bumi
            "Fire" -> R.drawable.fire  // Mengembalikan ID drawable untuk kebakaran
            "Nuclear Accident" -> R.drawable.nuclearaccident  // Mengembalikan ID drawable untuk kecelakaan nuklir
            "Wildfire" -> R.drawable.wildfire  // Mengembalikan ID drawable untuk kebakaran
            "Volcanic Eruption" -> R.drawable.volcaniceruption  // Mengembalikan ID drawable untuk gambar letusan gunung berapi
            "Drought" -> R.drawable.drought  // Mengembalikan ID drawable untuk gambar kekeringan
            "Hurricane" -> R.drawable.hurricane  // Mengembalikan ID drawable untuk gambar angin topan
            "Blizzard" -> R.drawable.blizzard  // Mengembalikan ID drawable untuk gambar badai salju
            "Chemical Spill" -> R.drawable.chemicalspill  // Mengembalikan ID drawable untuk gambar tumpahan bahan kimia
            "Oil Spill" -> R.drawable.oilspill  // Mengembalikan ID drawable untuk gambar tumpahan minyak
            else -> R.drawable.tsunami  // Mengembalikan gambar default (tsunami) jika nama bencana tidak sesuai dengan kasus yang ada
        }
    }
}
