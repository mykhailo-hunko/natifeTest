package com.natife.data.repositories

import com.natife.data.network.GifsApi
import com.natife.domain.models.gifModels.RootClass
import com.natife.domain.models.query.QueryParams
import com.natife.domain.repositories.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    val api: GifsApi
) : RemoteRepository {

    override suspend fun getGifsData(queryParams: QueryParams): RootClass {
        return api.getGifts("YGHnKKBGSydS6nSt6WAoUcICWwmgCfvL", queryParams.page, queryParams.limit, queryParams.query)
    }
}