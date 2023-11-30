package com.br.spotify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.br.spotify.ui.feature.home.HomeScreen
import com.br.spotify.ui.feature.InitialScreen
import com.br.spotify.ui.feature.playlist.PlayListScreen
import com.br.spotify.ui.feature.profile.ProfileScreen
import com.br.spotify.ui.feature.viewModel.ViewModelSpoty

@Composable
internal fun NavigationGraphContest(
    navController: NavHostController,
    viewModel: ViewModelSpoty
) {
    NavHost(
        navController = navController,
        startDestination = SpotytRoute.SpotytInitial.route
    ) {

        composable(route = SpotytRoute.SpotytInitial.route) {
            InitialScreen(navController)
        }

        composable(route = SpotytRoute.SpotytHome.route) {
            HomeScreen(navController, viewModel)
        }

        composable(route = SpotytRoute.SpotytPLasyList.route) {
            PlayListScreen(navController, viewModel)
        }

        composable(route = SpotytRoute.SpotytProfile.route) {
            ProfileScreen(navController, viewModel)
        }

    }
}
