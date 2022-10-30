package com.natife.ui.gif_grid

import androidx.lifecycle.ViewModel
import com.natife.domain.models.query.QueryParams
import com.natife.domain.use_cases.GetGifsDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class GifViewModel @Inject constructor(
    private val getGifsDataUseCase: GetGifsDataUseCase
) : ViewModel() {

    private val _searchWidgetState = MutableStateFlow(SearchWidgetState.CLOSED)
    val searchWidgetState: StateFlow<SearchWidgetState> = _searchWidgetState

    private val _searchTextState = MutableStateFlow("")
    val searchTextState: StateFlow<String> = _searchTextState


    @OptIn(ExperimentalCoroutinesApi::class)
    val listOfGifs = _searchTextState.flatMapLatest { query ->
        getGifsDataUseCase.invoke(QueryParams(query))
    }

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue

    }

}