package com.example.viewmodelexample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val usd_to_eu_rate = 0.74f
    var dollarValue: MutableLiveData<String> = MutableLiveData()
    //private var dollertext = ""
    //private var result: Float = 0f
    // result 변수를 MutableLiveData 인스턴스에 포함시키고, 이 변숫값의 변경을 관찰하는 옵저버를 생성
    var result: MutableLiveData<Float> = MutableLiveData()
    /*
    fun setAmount(value: String) {
        this.dollertext = value
        // .value 함수를 통해 MutableLiveData에 값을 추가한다.
        result.value = value.toFloat() * usd_to_eu_rate
    }
    // MutablaLivaData 객체를 반환하도록 수정
    fun getResult(): MutableLiveData<Float> {
        return result
    }
     */

    fun convertValue() {
        dollarValue.let {
            if (!it.value.equals("")) {
                result.value = it.value?.toFloat()?.times(usd_to_eu_rate)
            } else {
                result.value = 0f
            }
        }
    }
}