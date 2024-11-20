package com.example.e_commerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.ui.theme.EcommerceTheme
import com.example.e_commerce.viewModel.CategoriesScreenViewModel
import com.example.e_commerce.views.CategoriesRoute
import com.example.e_commerce.views.CategoriesScreen
import com.example.e_commerce.views.FavoriteRoute
import com.example.e_commerce.views.FavoritesScreen
import com.example.e_commerce.views.HomeRoute
import com.example.e_commerce.views.HomeScreen
import com.example.e_commerce.views.ProfileRoute
import com.example.e_commerce.views.ProfileScreen
import com.example.e_commerce.views.SignIn
import com.example.e_commerce.views.SignInRoute
import com.example.e_commerce.views.SignUpRoute
import com.example.e_commerce.views.Signup
import com.example.e_commerce.views.widgets.MyBottomAppBar
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            EcommerceTheme {

                val navController = rememberNavController()

                Scaffold(bottomBar = {
                    val currentRoute = navController.currentBackStackEntry?.destination?.route
                    if (currentRoute != null && currentRoute  in  listOf(HomeRoute , CategoriesRoute , FavoriteRoute , ProfileRoute)){
                        MyBottomAppBar(navController = navController)
                    }

                }) { paddingValues ->

                    AppNavigation(navController = navController , modifier = Modifier.fillMaxSize().padding(paddingValues))

                }
            }

        }
    }
}



@Composable
fun AppNavigation(

    navController: NavHostController,
    modifier: Modifier

) {


    NavHost(
        navController = navController,
        startDestination = SignInRoute,

    ) {

        composable<SignInRoute> {
            SignIn(navController = navController)
        }

        composable<SignUpRoute> {
            Signup(navController = navController)
        }

        composable<HomeRoute> {
            HomeScreen()
        }

        composable<CategoriesRoute> {
            val viewModel: CategoriesScreenViewModel = viewModel()
            CategoriesScreen(
                categoriesViewModel = viewModel,
                modifier = Modifier
            )
        }

        composable<FavoriteRoute> {
            FavoritesScreen()
        }

        composable<ProfileRoute> {
            ProfileScreen()
        }

    }

}