package com.natife.data.network

import com.natife.domain.models.gifModels.RootClass
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsApi {

    @GET("search")
    suspend fun getGifts(
        @Query("api_key") key: String,
        @Query("offset") page: Int,
        @Query("limit") limit: Int,
        @Query("q") query: String
    ): RootClass
}