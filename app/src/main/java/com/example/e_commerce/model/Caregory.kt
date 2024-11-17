package com.example.e_commerce.model

import com.example.e_commerce.R


data class Category(var image: Int,
                    var imageDescription: String)

var CategoriesList = listOf(
    Category(R.drawable.mens, "Men's Fashion"),
    Category(R.drawable.girl, "Cameras"),
    Category(R.drawable.head, "Head Phones"),
    Category(R.drawable.kleidung, "Women's Fashion"),
    Category(R.drawable.makeup, "Makeup"),
    Category(R.drawable.skincare, "Skin care"),
    Category(R.drawable.skirt, "Skirt")
)
