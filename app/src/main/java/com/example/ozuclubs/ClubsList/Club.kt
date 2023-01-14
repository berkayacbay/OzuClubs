package com.example.ozuclubs.ClubsList

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Club(
   @StringRes var clubName: Int,
   @DrawableRes var clubImage: Int) : java.io.Serializable {

}
