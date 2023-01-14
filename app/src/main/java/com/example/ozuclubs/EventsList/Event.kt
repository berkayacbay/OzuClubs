package com.example.ozuclubs.EventsList

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Event(
    @StringRes var eventHeader: Int,
   @StringRes  var eventBriefDesc: Int,
   @DrawableRes var eventImage: Int) :
    java.io.Serializable {


}
