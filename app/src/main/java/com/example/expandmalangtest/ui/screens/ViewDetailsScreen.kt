package com.example.expandmalangtest.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expandmalangtest.data.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewDetailsScreen(
    place: Place,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9FBFA))
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onBackClick) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF1B4332))
            }
            Text(text = "View Details", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B4332))
            IconButton(onClick = { }) {
                Icon(Icons.Default.Share, contentDescription = "Share", tint = Color(0xFF1B4332))
            }
        }

        Box(modifier = Modifier.fillMaxWidth().height(350.dp)) {
            Image(
                painter = painterResource(id = place.imageRes),
                contentDescription = place.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier.fillMaxSize().background(
                    Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)), startY = 300f)
                )
            )
            Column(modifier = Modifier.align(Alignment.BottomStart).padding(20.dp)) {
                Box(
                    modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(Color(0xFF0F8A5F)).padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text("Recommended", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = place.name, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 32.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.LocationOn, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = place.location, color = Color.White, fontSize = 12.sp)
                }
            }
        }

        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = "Tentang Destinasi", color = Color(0xFF1B4332), fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = place.fullDescription, color = Color.DarkGray, fontSize = 14.sp, lineHeight = 22.sp)

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Fasilitas", color = Color(0xFF1B4332), fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))

            val chunkedFacilities = place.facilities.chunked(2)
            chunkedFacilities.forEach { rowFacilities ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    rowFacilities.forEach { facility ->
                        FacilityItem(icon = facility.icon, name = facility.name, modifier = Modifier.weight(1f))
                    }
                    if (rowFacilities.size == 1) Spacer(modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Informasi Perjalanan", color = Color(0xFF1B4332), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Schedule, contentDescription = null, tint = Color.DarkGray)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("Durasi Perjalanan", fontSize = 12.sp, color = Color.Gray)
                            Text(place.travelDuration, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Payments, contentDescription = null, tint = Color.DarkGray)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("Mulai Dari", fontSize = 12.sp, color = Color.Gray)
                            Row {
                                Text(place.price, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F8A5F))
                                Text("/orang", fontSize = 12.sp, color = Color.Gray, modifier = Modifier.align(Alignment.Bottom))
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun FacilityItem(icon: androidx.compose.ui.graphics.vector.ImageVector, name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.clip(RoundedCornerShape(12.dp)).background(Color(0xFFF2F6FB)).padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = name, tint = Color(0xFF0F8A5F), modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = name, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF102A43))
    }
}