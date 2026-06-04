package com.rafario.a100m.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateOrderScreen(
    onBackClick: () -> Unit
) {
    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Nuevo pedido")
                },
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBackIosNew,
                        contentDescription = "back",
                        modifier = Modifier.clickable {
                            onBackClick()
                        }.padding(6.dp))
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Pantalla para realizar un pedido")
            Text(text = "Aquí añadiremos el catálogo y el carrito.")
        }
    }
}
