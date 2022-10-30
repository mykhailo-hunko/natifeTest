package com.natife.domain.models.gifModels

import com.google.gson.annotations.SerializedName


data class User (

  @SerializedName("avatar_url"    ) var avatarUrl    : String?  = null,
  @SerializedName("banner_image"  ) var bannerImage  : String?  = null,
  @SerializedName("banner_url"    ) var bannerUrl    : String?  = null,
  @SerializedName("profile_url"   ) var profileUrl   : String?  = null,
  @SerializedName("username"      ) var username     : String?  = null,
  @SerializedName("display_name"  ) var displayName  : String?  = null,
  @SerializedName("description"   ) var description  : String?  = null,
  @SerializedName("instagram_url" ) var instagramUrl : String?  = null,
  @SerializedName("website_url"   ) var websiteUrl   : String?  = null,
  @SerializedName("is_verified"   ) var isVerified   : Boolean? = null

)