package com.natife.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.natife.domain.models.gifModels.Data
import com.natife.domain.models.query.QueryParams
import com.natife.domain.repositories.RemoteRepository

class GifDataSource(
    private val repo: RemoteRepository,
    private val queryParams: QueryParams
) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val page = params.key ?: 1
            val response = repo.getGifsData(queryParams.copy(page = page))
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = if (response.data.isNotEmpty()) response.pagination?.offset?.plus(1) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}