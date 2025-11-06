package com.example.navigationp6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost // Import NavHost
import androidx.navigation.compose.composable // Import composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationp6.view.FormIsian
import com.example.navigationp6.view.TampilData

// 1. Perbaikan: Ubah nama enum ke bahasa Inggris agar konsisten (best practice)
enum class NavigasiRute {
    FormulirKu, // Rute untuk FormIsian
    Detail // Rute untuk TampilData
}

@Composable
fun DataApp(
    // 2. Perbaikan: Ubah 'nayController' menjadi 'navController' agar standar dan mudah dibaca
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier // Beri nilai default pada modifier
){
    Scaffold { isiRuang->
        NavHost(
            // 3. Perbaikan: Menggunakan navController yang benar
            navController = navController,
            startDestination = NavigasiRute.FormulirKu.name, // Menggunakan enum yang diperbaiki
            modifier = Modifier.padding(paddingValues = isiRuang)
        ){
            // 4. Perbaikan: Menggunakan enum yang diperbaiki dan penamaan rute yang benar
