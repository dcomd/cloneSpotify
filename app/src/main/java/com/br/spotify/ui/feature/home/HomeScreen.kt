package com.br.spotify.ui.feature.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.br.spotify.Components
import com.br.spotify.R
import com.br.spotify.ui.feature.BottomComponent
import com.br.spotify.ui.feature.UiState
import com.br.spotify.ui.feature.viewModel.ViewModelSpoty
import com.br.spotify.ui.navigation.SpotytRoute

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(navController: NavController, viewModelSpoti: ViewModelSpoty) {
    val initViewModel = viewModelSpoti.initState.observeAsState()

    LaunchedEffect(true) {
        viewModelSpoti.fetchData()
    }

    when (initViewModel.value){
        is UiState.Success -> SpotifyLikeScreen(navController)
        else -> SpotifyLikeScreen(navController = navController)
    }
}


@Composable
fun SpotifyLikeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black),
                title = {
                    Text(
                        text = "Top artistas",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.16.sp,
                        )
                    )
                },
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_image),
                        contentDescription = null,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .clip(CircleShape)
                    )
                },
                backgroundColor = Color.Black,
                contentColor = Color.White
            )
        },
        bottomBar = {
            BottomComponent.CustomBottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        SpotifyLikeContent(modifier)
    }
}




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SpotifyLikeContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val list  = Components.getInfo(context = context)
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        items(list!!.size) { index ->
            ListItem(
                modifier = Modifier.clickable {  },
                icon = {
                    Image(
                        painter = rememberAsyncImagePainter(list[index].images!!.first().url),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                },
                text = {
                    Text(
                        text = list[index].name!!,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .fillMaxWidth()
                    )
                }
            )

        }
    }
}