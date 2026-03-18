package com.example.modul4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modul4.service.ApiClient
import com.example.modul4.ui.theme.Modul4Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Modul4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CatFactScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CatFactScreen(modifier: Modifier = Modifier) {

    var factText by remember {
        mutableStateOf("Tekan tombol di bawah untuk memuat data")
    }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = factText,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                factText = "Memuat data..."

                coroutineScope.launch {
                    try {
                        val response = ApiClient.apiService.getRandomFact()

                        if (response.isSuccessful && response.body() != null) {
                            factText = response.body()!!.fact
                        } else {
                            factText = "Gagal memuat data."
                        }

                    } catch (e: Exception) {
                        factText = "Terjadi kesalahan."
                    }
                }
            }
        ) {
            Text("Muat fakta baru")
        }
    }
}