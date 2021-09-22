package com.example.cryptocurrency_cleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptocurrency_cleanarchitecture.presentation.coin_list.ComposeCoinListScreen
import com.example.cryptocurrency_cleanarchitecture.presentation.theme.CryptoCurrency_CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrency_CleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "coins") {
                        composable("coins") { ComposeCoinListScreen(navController) }
                        composable(
                            "coins/{coinId}",
                            arguments = listOf(navArgument("coinId") { type = NavType.StringType })
                        ) {
                            Text(text = "Coin id: ${it.arguments?.getString("coinId")}")
                        }
                    }
                }
            }
        }
    }
}