package com.demo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoModel(
    var adult: Boolean ?= false,
    var backdrop_path : String ?= "",
    var homepage: String ?= ""
) : Parcelable