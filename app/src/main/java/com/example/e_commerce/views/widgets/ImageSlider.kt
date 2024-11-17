package com.example.e_commerce.views.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_commerce.ui.theme.blue
import com.example.e_commerce.viewModel.ImageSliderViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider(modifier: Modifier = Modifier,vm: ImageSliderViewModel = viewModel()) {

    val pageState = rememberPagerState(initialPage = 0)


    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pageState.animateScrollToPage(
                page = (pageState.currentPage + 1) % (pageState.pageCount)
            )
        }
    }

    Box(modifier = modifier) {
        HorizontalPager(
            count = vm.imageSlider.size,
            state = pageState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
                .height(200.dp)
                .fillMaxWidth()
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    lerp(
                        start = 0.85F,
                        stop = 1F,
                        fraction = 1F - pageOffset.coerceIn(0F, 1F)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    alpha = lerp(
                        start = 0.5F,
                        stop = 1F,
                        fraction = 1F - pageOffset.coerceIn(0F, 1F)
                    )
                }
            ) {
                Image(
                    painter = painterResource(id = vm.imageSlider[page]),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            activeColor = blue,
            inactiveColor = Color.White
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ImageSliderPreview() {
    ImageSlider()
}