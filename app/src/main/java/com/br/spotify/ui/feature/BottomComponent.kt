package com.br.spotify.ui.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.br.spotify.R
import com.br.spotify.ui.navigation.SpotytRoute

object BottomComponent {

    @Composable
    fun CustomBottomNavigation(navController: NavController) {
        BottomNavigation(
            modifier = Modifier.navigationBarsPadding(),
            backgroundColor = Color.Black
        ) {
            BottomNavigationItem(
                selected = true,
                onClick = { navController.navigate(SpotytRoute.SpotytHome.route) },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_artista),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(35.dp)
                            .height(35.dp)
                    )
                },
            )
            BottomNavigationItem(
                selected = true,
                onClick = { navController.navigate(SpotytRoute.SpotytPLasyList.route) },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(35.dp)
                            .height(35.dp)

                    )
                },
            )
            BottomNavigationItem(
                selected = true,
                onClick = { navController.navigate(SpotytRoute.SpotytProfile.route) },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "image description",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(35.dp)
                            .height(35.dp)

                    )
                },
            )
        }
    }
}