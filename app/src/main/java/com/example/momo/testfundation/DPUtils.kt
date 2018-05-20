package com.example.momo.testfundation

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

/**
 * Created by liuxu on 2018/5/20.
 */
class DPUtils{

    private var mContext :Context?=null

    private constructor(context: Context){
        mContext = context
    }


    fun getInstance(context: Context):DPUtils{
        return DPUtils(context)
    }
    fun getPixels(dip: Float): Int {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getDisplayMetrics()))
    }

    fun getDisplayMetrics(): DisplayMetrics {
        return mContext!!.getResources().getDisplayMetrics()
    }
}