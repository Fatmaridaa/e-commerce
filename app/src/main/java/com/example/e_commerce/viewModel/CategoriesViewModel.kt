package com.example.e_commerce.viewModel
import androidx.lifecycle.ViewModel
import com.example.e_commerce.R

class CategoriesViewModel : ViewModel() {

    val categoryItem = listOf(

        Pair(R.drawable.women_fashion, "Women's \n fashion"),
        Pair(R.drawable.beauty, "Beauty"),
        Pair(R.drawable.men_fashion, " Men's\nfashion"),
        Pair(R.drawable.headphones, "Headphone"),
        Pair(R.drawable.labtops, "Laptops & \n Electronic"),
        Pair(R.drawable.skincare, "Skincare"),
        Pair(R.drawable.baby, "Baby \n Toy"),
        Pair(R.drawable.camera, "Camera"),
    )
}