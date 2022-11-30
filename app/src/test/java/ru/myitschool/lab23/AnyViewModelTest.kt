package ru.myitschool.lab23

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.math.abs

class AnyViewModelTest {

    var model: AnyViewModel? = null

    @Before
    fun setUp() {
        model = AnyViewModel()
    }

    @After
    fun tearDown() {
        model = null
    }

    @Test
    fun test1() {
        val needMean = 2.0f
        val needPrecision = 1.0f
        var calculatedMean = 0.0f
        model?.run {
            mean.value = needMean
            variance.value = 2.0f
            var sum = 0.0f
            val n = 100
            for (i in 1..n) {
                onGetResultClick()
                sum += result.value?:0.0f
            }
            calculatedMean = sum / n
        }
        assertTrue(abs(calculatedMean - needMean) < needPrecision)
    }
}