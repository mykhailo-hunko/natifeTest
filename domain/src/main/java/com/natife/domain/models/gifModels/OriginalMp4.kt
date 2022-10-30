package com.natife.domain.models.gifModels

import com.google.gson.annotations.SerializedName


data class OriginalMp4 (

  @SerializedName("height"   ) var height  : String? = null,
  @SerializedName("width"    ) var width   : String? = null,
  @SerializedName("mp4_size" ) var mp4Size : String? = null,
  @SerializedName("mp4"      ) var mp4     : String? = null

)