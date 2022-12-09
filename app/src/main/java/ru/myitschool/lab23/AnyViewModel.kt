package ru.myitschool.lab23

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.apache.commons.math3.distribution.LogNormalDistribution
import org.apache.commons.math3.distribution.NormalDistribution
import java.util.Random
import kotlin.math.exp
import kotlin.math.sqrt

class AnyViewModel: ViewModel() {
    val mean = MutableLiveData<Float>()
    val variance = MutableLiveData<Float>()
    val result = MutableLiveData<Float?>(null)

    fun onGetResultClick() {
        val m: Float = if (mean.value != null) mean.value!! else .0f
        val v: Float = if (variance.value != null) variance.value!! else .0f
        if (v >= 0) {
            val normVal = exp(sqrt(v) * Random().nextGaussian() + m)

            result.value = normVal.toFloat()
            return
        }
        result.value = m
    }
}