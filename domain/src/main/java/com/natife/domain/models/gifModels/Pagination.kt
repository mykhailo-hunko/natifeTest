package com.natife.domain.models.gifModels

import com.google.gson.annotations.SerializedName


data class Pagination (

  @SerializedName("total_count" ) var totalCount : Int? = null,
  @SerializedName("count"       ) var count      : Int? = null,
  @SerializedName("offset"      ) var offset     : Int? = null

)