package com.natife.ui.viewer

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.fragment.navArgs
import androidx.paging.compose.collectAsLazyPagingItems
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.natife.domain.models.gifModels.Data
import com.natife.ui.gif_grid.GifViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GifViewerFragment : Fragment() {

    private val viewModel: GifViewModel by activityViewModels()

    private val args: GifViewerFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Box(modifier = Modifier.fillMaxSize()) {
                    HorizontalPagerScreen(viewModel, args.index)
                }
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
    @Composable
    fun HorizontalPagerScreen(viewModel: GifViewModel = hiltViewModel(), index: Int) {
        var isFirstOpen by remember {
            mutableStateOf(true)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            val items = viewModel.listOfGifs.collectAsLazyPagingItems()
            val pagerState = rememberPagerState()
            CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
                HorizontalPager(
                    count = items.itemCount,
                    state = pagerState,
                    modifier = Modifier.weight(1f),
                ) { currentPage ->
                    GifItem2(item = items[currentPage])
                }

                val coroutineScope = rememberCoroutineScope()
                LaunchedEffect(pagerState.pageCount) {
                    if (pagerState.pageCount > 10 && isFirstOpen) {
                        isFirstOpen = false
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Fragment.GifItem2(item: Data?) {
        val imageLoader = ImageLoader.Builder(requireContext())
            .components {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()
        val painter = rememberAsyncImagePainter(
            model = item?.images?.downsized?.url,
            imageLoader = imageLoader
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            AnimatedVisibility(
                visible = when (painter.state) {
                    is AsyncImagePainter.State.Empty,
                    is AsyncImagePainter.State.Success,
                    -> false
                    is AsyncImagePainter.State.Loading,
                    is AsyncImagePainter.State.Error,
                    -> true
                    else -> {
                        false
                    }
                }
            ) {
                CircularProgressIndicator(color = Color.Magenta)
            }
        }
    }
}