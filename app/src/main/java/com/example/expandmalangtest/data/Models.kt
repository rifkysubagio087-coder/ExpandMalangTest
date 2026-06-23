package com.example.expandmalangtest.data

import androidx.annotation.DrawableRes
import com.example.expandmalangtest.R

data class Place(
    val id: Int,
    val name: String,
    val location: String,
    val price: String,
    val description: String,
    @DrawableRes val imageRes: Int
)

data class Trip(
    val id: Int,
    val name: String,
    val date: String,
    @DrawableRes val imageRes: Int
)

object SampleData {
    val places = listOf(
        Place(
            1, "Mount Bromo", "Probolinggo, Malang Region", "$15",
            "Iconic volcano with breathtaking sunrise views.", R.drawable.ic_bromo
        ),
        Place(
            2, "Museum Angkut", "Batu, Malang", "$10",
            "Classic vehicles museum in Batu.", R.drawable.ic_museum_angkut
        ),
        Place(
            3, "Kampung Warna Warni", "Malang City", "$2",
            "Vibrant rainbow village community.", R.drawable.ic_jodipan
        ),
        Place(
            4, "Tumpak Sewu Fall", "Lumajang", "$5",
            "Majestic multi-tiered waterfall.", R.drawable.ic_tumpak_sewu
        )
    )

    val trips = listOf(
        Trip(1, "Bromo Midnight", "Dec 24, 2024 - 23:30", R.drawable.ic_bromo),
        Trip(2, "Tumpak Sewu Fall", "Jan 05, 2025 - 08:00", R.drawable.ic_tumpak_sewu),
        Trip(3, "Museum Angkut", "Nov 12, 2024", R.drawable.ic_museum_angkut)
    )
}
