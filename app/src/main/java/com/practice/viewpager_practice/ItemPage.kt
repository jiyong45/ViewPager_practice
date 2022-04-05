package com.practice.viewpager_practice

import android.content.Context

class ItemPage (
    var pageImage : String,
    var mainTitle : String,
    var subTitle : String,
    var descript : String
    ){
    fun getItemId(context: Context): Int {
        return context.resources.getIdentifier(pageImage,"drawable",context.packageName)
    }

}