package com.natife.domain.models.gifModels

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("type"                       ) var type                     : String?    = null,
  @SerializedName("id"                         ) var id                       : String?    = null,
  @SerializedName("url"                        ) var url                      : String?    = null,
  @SerializedName("slug"                       ) var slug                     : String?    = null,
  @SerializedName("bitly_gif_url"              ) var bitlyGifUrl              : String?    = null,
  @SerializedName("bitly_url"                  ) var bitlyUrl                 : String?    = null,
  @SerializedName("embed_url"                  ) var embedUrl                 : String?    = null,
  @SerializedName("username"                   ) var username                 : String?    = null,
  @SerializedName("source"                     ) var source                   : String?    = null,
  @SerializedName("title"                      ) var title                    : String?    = null,
  @SerializedName("rating"                     ) var rating                   : String?    = null,
  @SerializedName("content_url"                ) var contentUrl               : String?    = null,
  @SerializedName("source_tld"                 ) var sourceTld                : String?    = null,
  @SerializedName("source_post_url"            ) var sourcePostUrl            : String?    = null,
  @SerializedName("is_sticker"                 ) var isSticker                : Int?       = null,
  @SerializedName("import_datetime"            ) var importDatetime           : String?    = null,
  @SerializedName("trending_datetime"          ) var trendingDatetime         : String?    = null,
  @SerializedName("images"                     ) var images                   : Images?    = Images(),
  @SerializedName("user"                       ) var user                     : User?      = User(),
  @SerializedName("analytics_response_payload" ) var analyticsResponsePayload : String?    = null,
  @SerializedName("analytics"                  ) var analytics                : Analytics? = Analytics()

)