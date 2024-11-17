package com.example.e_commerce.views.widgets
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.e_commerce.ui.theme.blue
import com.example.e_commerce.views.CategoriesRoute
import com.example.e_commerce.views.FavoriteRoute
import com.example.e_commerce.views.HomeRoute
import com.example.e_commerce.views.ProfileRoute

@Composable
fun MyBottomAppBar(navController: NavHostController) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
        containerColor = blue,
        contentColor = Color.White,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            // Home
            BottomNavItem(
                icon = Icons.Outlined.Home,
                isSelected = selectedIndex == 0,
                onClick = {
                    selectedIndex = 0
                    navController.navigate(HomeRoute)
                }
            )
            // Categories
            BottomNavItem(
                icon = Icons.Outlined.GridView,
                isSelected = selectedIndex == 1,
                onClick = {
                    selectedIndex = 1
                    navController.navigate(CategoriesRoute)
                }
            )
            // Favorites
            BottomNavItem(
                icon = Icons.Filled.FavoriteBorder,
                isSelected = selectedIndex == 2,
                onClick = {
                    selectedIndex = 2
                    navController.navigate(FavoriteRoute)
                }
            )
            // Profile
            BottomNavItem(
                icon = Icons.Filled.PersonOutline,
                isSelected = selectedIndex == 3,
                onClick = {
                    selectedIndex = 3
                    navController.navigate(ProfileRoute)
                }
            )
        }
    }
}



@Composable
fun BottomNavItem(
    icon: ImageVector,
    isSelected: Boolean,
    onClick:  () -> Unit,
) {
    Box(
        modifier =
            Modifier
                .fillMaxHeight(),
        contentAlignment = Alignment.Center,
    ) {
        IconButton(
            onClick = onClick,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) White else Color.Transparent),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isSelected) blue else White,
                )
            }
        }
    }
}
