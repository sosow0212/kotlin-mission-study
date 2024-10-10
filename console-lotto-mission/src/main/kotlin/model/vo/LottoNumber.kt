package com.model.vo

import com.model.exception.LottoNumberInvalidException

data class LottoNumber(
    val number: Int
) {
    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45

        fun from(number: Int): LottoNumber {
            if (number !in START_NUMBER..END_NUMBER) {
                throw LottoNumberInvalidException()
            }

            return LottoNumber(number)
        }
    }
}
