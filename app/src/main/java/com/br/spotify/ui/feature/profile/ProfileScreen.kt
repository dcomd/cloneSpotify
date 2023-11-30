package com.br.spotify.ui.feature.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.br.spotify.Components
import com.br.spotify.ui.feature.BottomComponent
import com.br.spotify.ui.feature.UiState
import com.br.spotify.ui.feature.viewModel.ViewModelSpoty
import com.br.spotify.ui.navigation.SpotytRoute

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProfileScreen(navController: NavController, viewModelSpoti: ViewModelSpoty) {
    val initViewModel = viewModelSpoti.initState.observeAsState()

    LaunchedEffect(true) {
        viewModelSpoti.fetchData()
    }

    when (initViewModel.value){
        is UiState.SuccessProfile -> SpotifyLikeScreen(navController)
        else -> SpotifyLikeScreen(navController)
    }
}


@Composable
fun SpotifyLikeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {},
        bottomBar = {
            BottomComponent.CustomBottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        SpotifyLikeContent(modifier, navController)
    }
}

@Composable
fun SpotifyLikeContent(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    val list  = Components.getProfile(context = context)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Image(
            painter = rememberAsyncImagePainter(list.images.first().url),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(150.dp)
                .clip(CircleShape)
        )

        androidx.compose.material3.Text(list.display_name, color = Color.White, fontSize = 25.sp, fontWeight = FontWeight(500))

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(SpotytRoute.SpotytHome.route)
        }, Modifier.width(150.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF57B660)))
        { androidx.compose.material3.Text("Sair", color = Color.Black) }
    }

}
