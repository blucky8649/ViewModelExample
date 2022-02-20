package com.example.viewmodelexample.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val usd_to_eu_rate = 0.74f
    private var dollertext = ""
    private var result: Float = 0f

    fun setAmount(value: String) {
        this.dollertext = value
        result = value.toFloat() * usd_to_eu_rate
    }

    fun getResult(): Float? {
        return result
    }
}