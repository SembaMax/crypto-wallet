package com.semba.cryptowallet.common.utils

fun String.hexStringToByteArray() : ByteArray {
    val hexChars = "0123456789ABCDEF"
    val result = ByteArray(length / 2)
    for (i in 0 until length step 2) {
        val firstIndex = hexChars.indexOf(this[i].uppercaseChar())
        val secondIndex = hexChars.indexOf(this[i + 1].uppercaseChar())
        val octet = firstIndex.shl(4).or(secondIndex)
        result.set(i.shr(1), octet.toByte())
    }
    return result
}