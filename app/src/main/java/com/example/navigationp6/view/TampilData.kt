package com.example.navigationp6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationp6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    onBackBtnClick: () -> Unit
) {
    // 1. Perbaikan: Mengganti string hardcoded "ALAMAT" dengan R.string jika tersedia.
    // Asumsi R.string.alamat sudah didefinisikan di strings.xml
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama_lengkap), second = "Contoh Nama"),
        Pair(first = stringResource(id = R.string.jenis_kelamin), second = "Lainnya"),
        Pair(first = "Alamat", second = "Yogyakarta") // Jika R.string.alamat belum tersedia
        // Gunakan: Pair(first = stringResource(id = R.string.alamat), second = "Yogyakarta") jika ada
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.tampil),
                        color = Color.White
                    )
                },
                // Menggunakan TopAppBarDefaults.topAppBarColors untuk Material 3
                colors = TopAppBarDefaults
                    .topAppBarColors(
                        containerColor = colorResource(id = R.color.teal_700)
                    )
            )
        }) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
                .fillMaxWidth(), // Pastikan Column mengisi lebar penuh
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(all = dimensionResource(id = R.dimen.padding_medium))
                    .weight(1f), // Agar Column data mengambil semua sisa ruang
                verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_small))
            ) {
                // Tampilkan Data
                items.forEach { item ->
                    Column {
                        Text(
                            text = item.first.uppercase(),
                            fontSize = 16.sp
                        )
                        Text(
                            text = item.second,
                            fontWeight = FontWeight.Bold,
                            // 2. Perbaikan: Penulisan FontFamily yang benar
                            fontFamily = FontFamily.Cursive,
                            fontSize = 22.sp
                        )
                    }
                    // 3. Perbaikan: Menambahkan padding horizontal pada Divider
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 4.dp),
                        thickness = 1.dp,
                        color = Color.Cyan
                    )
                }
            }

            // Tombol "Kembali" diletakkan di bagian bawah terpisah
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
                    .padding(bottom = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Spacer(modifier = Modifier.height(height = 10.dp)) // Jarak antar data terakhir dengan tombol
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackBtnClick
                ) {
                    Text(text = stringResource(id = R.string.back))
                }
            }
        }
    }
}