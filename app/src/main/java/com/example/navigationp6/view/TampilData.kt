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
