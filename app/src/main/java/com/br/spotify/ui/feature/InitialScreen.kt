package com.br.spotify.ui.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.br.spotify.ui.navigation.SpotytRoute


@Composable
fun InitialScreen(navController: NavController) {
    Initial(navController = navController)
}

@Composable
fun Initial(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text("Entre com sua conta Spotify", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight(500))

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
           navController.navigate(SpotytRoute.SpotytHome.route)
        }, Modifier.width(150.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF57B660)))
        { Text("Entrar", color = Color.Black) }
    }
}