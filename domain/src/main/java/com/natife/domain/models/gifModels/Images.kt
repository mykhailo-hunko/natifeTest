package com.natife.domain.models.gifModels

import com.google.gson.annotations.SerializedName
import com.natife.domain.models.gifModels.*

data class Images(

    @SerializedName("original") var original: Original? = Original(),
    @SerializedName("downsized") var downsized: Downsized? = Downsized(),
    @SerializedName("downsized_large") var downsizedLarge: DownsizedLarge? = DownsizedLarge(),
    @SerializedName("downsized_medium") var downsizedMedium: DownsizedMedium? = DownsizedMedium(),
    @SerializedName("downsized_small") var downsizedSmall: DownsizedSmall? = DownsizedSmall(),
    @SerializedName("downsized_still") var downsizedStill: DownsizedStill? = DownsizedStill(),
    @SerializedName("fixed_height") var fixedHeight: FixedHeight? = FixedHeight(),
    @SerializedName("fixed_height_downsampled") var fixedHeightDownsampled: FixedHeightDownsampled? = FixedHeightDownsampled(),
    @SerializedName("fixed_height_small") var fixedHeightSmall: FixedHeightSmall? = FixedHeightSmall(),
    @SerializedName("fixed_height_small_still") var fixedHeightSmallStill: FixedHeightSmallStill? = FixedHeightSmallStill(),
    @SerializedName("fixed_height_still") var fixedHeightStill: FixedHeightStill? = FixedHeightStill(),
    @SerializedName("fixed_width") var fixedWidth: FixedWidth? = FixedWidth(),
    @SerializedName("fixed_width_downsampled") var fixedWidthDownsampled: FixedWidthDownsampled? = FixedWidthDownsampled(),
    @SerializedName("fixed_width_small") var fixedWidthSmall: FixedWidthSmall? = FixedWidthSmall(),
    @SerializedName("fixed_width_small_still") var fixedWidthSmallStill: FixedWidthSmallStill? = FixedWidthSmallStill(),
    @SerializedName("fixed_width_still") var fixedWidthStill: FixedWidthStill? = FixedWidthStill(),
    @SerializedName("looping") var looping: Looping? = Looping(),
    @SerializedName("original_still") var originalStill: OriginalStill? = OriginalStill(),
    @SerializedName("original_mp4") var originalMp4: OriginalMp4? = OriginalMp4(),
    @SerializedName("preview") var preview: Preview? = Preview(),
    @SerializedName("preview_gif") var previewGif: PreviewGif? = PreviewGif(),
    @SerializedName("preview_webp") var previewWebp: PreviewWebp? = PreviewWebp(),
    @SerializedName("hd") var hd: Hd? = Hd(),
    @SerializedName("480w_still") var wStill: wStill? = wStill()

)