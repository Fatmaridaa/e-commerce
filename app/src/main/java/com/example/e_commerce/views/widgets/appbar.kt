package com.example.e_commerce.views.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce.R
import com.example.e_commerce.ui.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopAppBar(
    onSearchClick: (() -> Unit)? = null,
    onCartClick: (() -> Unit)? = null,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 10.dp , end = 10.dp , bottom = 8.dp),
    ) {
                Image(
                    painter = painterResource(id = R.drawable.appbar_logo),
                    contentDescription = "App Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(50.dp),
                )

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
        ) {
            // Search Box
            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(70.dp))
                        .border(1.dp, Color(0, 65, 130, 255), RoundedCornerShape(70.dp)),
            ) {
                TextField(
                    value = "",
                    onValueChange = { },
                    shape = RoundedCornerShape(70.dp),
                    colors =
                        TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        ),
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "What do you search for?",
                            color = blue,
                            fontSize = 14.sp,
                        )
                    },
                    leadingIcon = {
                        IconButton(onClick = {
                            if (onSearchClick != null) {
                                onSearchClick()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search Icon",
                                tint = blue,
                                modifier = Modifier.size(35.dp),
                            )
                        }
                    },
                )
            }

            // Shopping Cart Icon
            IconButton(
                onClick = {
                    if (onCartClick != null) {
                        onCartClick()
                    }
                },
                modifier =
                    Modifier
                        .size(50.dp),
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Shopping Cart Icon",
                    tint = Color(0, 65, 130, 255),
                )
            }
        }
    }
}

@Preview
@Composable
private fun AppbarPrev() {
    SearchTopAppBar()
}
