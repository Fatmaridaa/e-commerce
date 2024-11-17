package com.example.e_commerce.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.views.widgets.Categories
import com.example.e_commerce.views.widgets.HomeAppliance
import com.example.e_commerce.views.widgets.ImageSlider
import com.example.e_commerce.views.widgets.SearchTopAppBar

import kotlinx.serialization.Serializable


@Serializable
object HomeRoute

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        // SearchBar item
        item {
            SearchTopAppBar()
        }

        // ImageSlider item
        item {
            ImageSlider()
        }

        // Categories item
        item {
            Categories()
        }

        // HomeAppliance item
        item {
            HomeAppliance()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenView() {
    HomeScreen()
}