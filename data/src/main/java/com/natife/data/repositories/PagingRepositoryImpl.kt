package com.natife.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.natife.data.GifDataSource
import com.natife.domain.models.gifModels.Data
import com.natife.domain.models.query.QueryParams
import com.natife.domain.repositories.PagingRepository
import com.natife.domain.repositories.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagingRepositoryImpl @Inject constructor(
    private val remoteRepository: RemoteRepository
) : PagingRepository {

    override fun getData(queryParams: QueryParams): Flow<PagingData<Data>> {
        return Pager(PagingConfig(pageSize = queryParams.limit)) {
            GifDataSource(remoteRepository, queryParams)
        }.flow
    }
}