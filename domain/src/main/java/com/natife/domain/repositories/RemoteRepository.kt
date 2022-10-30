package com.natife.domain.repositories

import com.natife.domain.models.gifModels.RootClass
import com.natife.domain.models.query.QueryParams

interface RemoteRepository {

    suspend fun getGifsData(queryParams: QueryParams): RootClass
}