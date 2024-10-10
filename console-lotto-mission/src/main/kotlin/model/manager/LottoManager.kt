package com.model.manager

import com.model.vo.LottoNumber

class LottoManager(
    val winningLottoNumbers: WinningLottoNumbers,
    val winningBonusNumber: LottoNumber
) {
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
