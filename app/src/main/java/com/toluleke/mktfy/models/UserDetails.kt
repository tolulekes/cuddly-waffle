package com.toluleke.mktfy.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDetails(
    var email: String= "",
    var password: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var phone: String = "",
    var country: String = "",
    var city: String = "",
    var address: String = ""
): Parcelable

