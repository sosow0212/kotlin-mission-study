package com.model.manager

import com.model.vo.LottoNumber

class WinningLottoNumbers(
    val winningLottoNumbers: List<LottoNumber>
) {
    companion object {
        fun from(numbers: List<Int>): WinningLottoNumbers {
            return WinningLottoNumbers(
                numbers.map { LottoNumber.from(it) }
            )
        }
    }
}
