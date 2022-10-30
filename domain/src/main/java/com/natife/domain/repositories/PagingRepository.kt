package com.natife.domain.repositories

import androidx.paging.PagingData
import com.natife.domain.models.gifModels.Data
import com.natife.domain.models.query.QueryParams
import kotlinx.coroutines.flow.Flow

interface PagingRepository {
    fun getData(queryParams: QueryParams): Flow<PagingData<Data>>
}