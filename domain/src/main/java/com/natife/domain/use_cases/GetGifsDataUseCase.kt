package com.natife.domain.use_cases

import androidx.paging.PagingData
import com.natife.domain.models.gifModels.Data
import com.natife.domain.models.query.QueryParams
import com.natife.domain.repositories.PagingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGifsDataUseCase @Inject constructor(
    private val pagingRepository: PagingRepository
) {
    operator fun invoke(queryParams: QueryParams): Flow<PagingData<Data>> {
        return pagingRepository.getData(queryParams)
    }
}