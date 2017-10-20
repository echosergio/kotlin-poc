package upm.dam.kotlindemo

import android.graphics.Color
import android.util.Log

class Company(val name: String, val color: Int = Color.RED) {

    val quarterEarnings = mutableListOf<QuarterlyEarnings>()

    init {
        Log.v("Company", "Company initialized with value ${name}")
    }

}

