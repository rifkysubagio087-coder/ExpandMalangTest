package com.example.expandmalangtest.data

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.expandmalangtest.R

data class Place(
    val id: Int,
    val name: String,
    val location: String,
    val price: String,
    val description: String,
    val fullDescription: String,
    val travelDuration: String,
    val facilities: List<Facility>,
    @DrawableRes val imageRes: Int
)

data class Facility(
    val icon: ImageVector,
    val name: String
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
            id = 1,
            name = "Mount Bromo",
            location = "Probolinggo, Malang Region",
            price = "Rp 350.000",
            description = "Iconic volcano with breathtaking sunrise views.",
            fullDescription = "Gunung Bromo adalah sebuah gunung berapi aktif di Jawa Timur, Indonesia. Gunung ini memiliki ketinggian 2.329 meter di atas permukaan laut dan terkenal sebagai objek wisata utama di Jawa Timur dengan pemandangan matahari terbit yang luar biasa.",
            travelDuration = "2 - 3 Jam dari Kota Malang",
            facilities = listOf(
                Facility(Icons.Default.Terrain, "Jalur Penanjakan"),
                Facility(Icons.Default.CameraAlt, "Spot Foto"),
                Facility(Icons.Default.Restaurant, "Warung Lokal")
            ),
            imageRes = R.drawable.ic_bromo
        ),
        Place(
            id = 2,
            name = "Museum Angkut",
            location = "Batu, Malang",
            price = "Rp 100.000",
            description = "Classic vehicles museum in Batu.",
            fullDescription = "Museum Angkut merupakan museum transportasi dan tempat wisata modern yang terletak di Kota Batu, Jawa Timur. Museum ini memiliki lebih dari 300 koleksi jenis angkutan tradisional hingga modern yang ditata dengan latar belakang zona-zona khas kota terkenal di dunia, mulai dari Zona Edukasi, Italia, Paris, hingga Hollywood. Pengunjung bisa belajar sejarah transportasi sekaligus berfoto di berbagai set film legendaris internasional.",
            travelDuration = "45 Menit - 1 Jam dari Kota Malang",
            facilities = listOf(
                Facility(Icons.Default.DirectionsCar, "Zona Edukasi"),
                Facility(Icons.Default.CameraAlt, "Spot Foto"),
                Facility(Icons.Default.Restaurant, "Food Court"),
                Facility(Icons.Default.LocalParking, "Parkir Luas"),
                Facility(Icons.Default.Wc, "Toilet & Bilas")
            ),
            imageRes = R.drawable.ic_museum_angkut
        ),
        Place(
            id = 3,
            name = "Kampung Warna Warni",
            location = "Malang City",
            price = "Rp 5.000",
            description = "Vibrant rainbow village community.",
            fullDescription = "Kampung Warna Warni Jodipan adalah salah satu destinasi wisata kreatif paling populer di pusat Kota Malang. Dahulunya merupakan kawasan pemukiman padat di bantaran Sungai Brantas, kini kampung ini disulap menjadi penuh warna dengan dinding, atap, dan jalanan yang dicat warna-warni cerah serta dihiasi berbagai mural artistik. Salah satu daya tarik utamanya adalah Jembatan Kaca yang menghubungkan kampung ini dengan Kampung Tridi.",
            travelDuration = "10 - 15 Menit dari Pusat Kota",
            facilities = listOf(
                Facility(Icons.Default.Brush, "Mural & Art"),
                Facility(Icons.Default.CameraAlt, "Spot Foto"),
                Facility(Icons.Default.Storefront, "Toko Suvenir"),
                Facility(Icons.Default.Restaurant, "Warung Lokal"),
                Facility(Icons.Default.Wc, "Toilet Umum")
            ),
            imageRes = R.drawable.ic_jodipan
        ),
        Place(
            id = 4,
            name = "Air Terjun Tumpak Sewu",
            location = "Pronojiwo, Lumajang",
            price = "Rp 150.000",
            description = "Majestic multi-tiered waterfall.",
            fullDescription = "Tumpak Sewu, juga dikenal sebagai Coban Sewu, adalah air terjun setinggi 120 meter yang terletak di antara Kabupaten Lumajang dan Kabupaten Malang. Air terjun ini sering dijuluki sebagai \"Niagara Indonesia\" karena formasi air terjunnya yang melingkar dan masif.\n\nPengalaman di sini tidak hanya sekadar melihat dari kejauhan, tetapi juga trekking menantang turun ke dasar lembah untuk menyaksikan kemegahan tirai air dari bawah.",
            travelDuration = "2.5 - 3 Jam dari Kota Malang",
            facilities = listOf(
                Facility(Icons.Default.Terrain, "Jalur Trekking"),
                Facility(Icons.Default.CameraAlt, "Spot Foto"),
                Facility(Icons.Default.LocalParking, "Parkir Luas"),
                Facility(Icons.Default.Restaurant, "Warung Lokal"),
                Facility(Icons.Default.Wc, "Toilet & Bilas"),
                Facility(Icons.Default.Person, "Pemandu Lokal")
            ),
            imageRes = R.drawable.ic_tumpak_sewu
        )
    )

    val trips = listOf(
        Trip(1, "Bromo Midnight", "Dec 24, 2024 - 23:30", R.drawable.ic_bromo),
        Trip(4, "Tumpak Sewu Fall", "Jan 05, 2025 - 08:00", R.drawable.ic_tumpak_sewu)
    )
}