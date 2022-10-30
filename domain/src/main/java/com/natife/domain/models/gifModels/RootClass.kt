package com.natife.domain.models.gifModels

import com.google.gson.annotations.SerializedName


data class RootClass (

    @SerializedName("data"       ) var data       : ArrayList<Data> = arrayListOf(),
    @SerializedName("pagination" ) var pagination : Pagination?     = Pagination(),
    @SerializedName("meta"       ) var meta       : Meta?           = Meta()

)