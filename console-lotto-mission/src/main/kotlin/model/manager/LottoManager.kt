package com.model.manager

import com.model.vo.LottoNumber

class LottoManager(
    private val winningLottoNumbers: WinningLottoNumbers,
    val winningBonusNumber: LottoNumber
) {
    val getWinningLottoNumbers: List<LottoNumber>
        get() = winningLottoNumbers.winningLottoNumbers

    companion object {
        fun of(
            winningLottoNumbers: List<Int>,
            winningBonusNumber: Int
        ): LottoManager {
            return LottoManager(
                WinningLottoNumbers.from(winningLottoNumbers),
                LottoNumber.from(winningBonusNumber)
            )
        }
    }
}
