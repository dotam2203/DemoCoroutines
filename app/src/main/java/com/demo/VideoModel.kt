package com.demo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  23/11/2022
 */
@Parcelize
data class VideoModel(
    var adult: Boolean ?= false,
    var backdrop_path : String ?= "",
    var homepage: String ?= ""
) : Parcelable