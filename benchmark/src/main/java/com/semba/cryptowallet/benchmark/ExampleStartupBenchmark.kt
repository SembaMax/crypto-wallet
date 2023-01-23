package com.semba.cryptowallet.benchmark

import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.max

/**
 * This is an example startup benchmark.
 *
 * It navigates to the device's home screen, and launches the default activity.
 *
 * Before running this benchmark:
 * 1) switch your app's active build variant in the Studio (affects Studio runs only)
 * 2) add `<profileable android:shell="true" />` to your app's manifest, within the `<application>` tag
 *
 * Run this benchmark from Studio to see startup measurements, and captured system traces
 * for investigating your app's performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = "com.semba.cryptowallet",
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        pressHome()
        startActivityAndWait()
    }
}

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val theTrustCounter = Array(n) { 0 }

    trust.forEach { it ->
        val trustGiver = it[0]
        val trusted = it[1]
        theTrustCounter[trustGiver - 1] = -1

        if (theTrustCounter[trusted] != -1)
        {
            theTrustCounter[trusted]++
        }
    }

    val index = getIndexOfLargest(theTrustCounter)

    return if (theTrustCounter[index] == -1) -1 else index + 1
}

fun getIndexOfLargest(array: Array<Int>): Int {
    if (array.size == 0) return -1
    var largest = 0
    for (i in 1 until array.size) {
        if (array[i] > array[largest]) largest = i
    }

    return largest
}