package com.example.e_commerce.views.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_commerce.R
import com.example.e_commerce.ui.theme.blue
import com.example.e_commerce.viewModel.CategoriesViewModel

@Composable
fun Categories(modifier: Modifier = Modifier,vm: CategoriesViewModel = viewModel()) {


    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.categories),
                fontSize = 20.sp,
                color = blue,
                modifier = Modifier.padding(10.dp)
            )

            TextButton(
                onClick = {
                    // Handle the click action here
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.view_all),
                    fontSize = 16.sp,
                    color = blue
                )
            }


        }

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(vm.categoryItem) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.first),
                        contentDescription = "Category Image",
                        modifier = Modifier
                            .size(95.dp), // Adjust the size as needed
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = item.second,
                        fontSize = 16.sp,
                        color = blue,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CategoriesPreview() {
    Categories()
}