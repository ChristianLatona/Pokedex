package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.presentation.pokemon_list.PokemonListScreen
import com.example.pokedex.presentation.pokemon_list.PokemonListViewModel
import com.example.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.toRoute
import com.example.pokedex.presentation.pokemon_detail.PokemonDetailScreen

@Serializable
object PokemonListRoute

@Serializable
data class PokemonDetailRoute(val pokemonName: String)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = PokemonListRoute
                    ) {
                        composable<PokemonListRoute> {
                            val pokemonListViewModel = hiltViewModel<PokemonListViewModel>()
                            PokemonListScreen(
                                navController,
                                pokemonListViewModel
                            )
                        }

                        composable<PokemonDetailRoute> {
                            val args = it.toRoute<PokemonDetailRoute>()
                            PokemonDetailScreen(
                                pokemonName = args.pokemonName,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}