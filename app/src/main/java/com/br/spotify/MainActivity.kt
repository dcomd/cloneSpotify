package com.br.spotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.br.spotify.ui.feature.viewModel.ViewModelSpoty
import com.br.spotify.ui.navigation.NavigationGraphContest
import com.br.spotify.ui.theme.SpotifyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ViewModelSpoty by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()
            SpotifyTheme {
                CallNavigation(navController, viewModel)
            }
        }
    }
}

@Composable
private fun CallNavigation(navController: NavHostController, viewModel: ViewModelSpoty) {
    NavigationGraphContest(
        navController,
        viewModel
    )
}