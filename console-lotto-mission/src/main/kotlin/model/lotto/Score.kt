package com.model.lotto

import com.model.vo.LottoNumber

enum class Score(
    val id: String,
    val price: Int
) {
    ZERO("꽝", 0),
    THREE("5등", 5000),
    FOURTH("4등", 50000),
    FIFTH("3등", 1500000),
    FIFTH_WITH_BONUS("2등", 30000000),
    SIX("1등", 2000000000);

    companion object {
        fun of(
            myNumbers: List<LottoNumber>,
            winningNumbers: List<LottoNumber>,
            winningBonusNumber: LottoNumber,
        ): Score {
            val matchingCount = myNumbers.intersect(winningNumbers.toSet()).size
            val isBonusCorrect = myNumbers.contains(winningBonusNumber)

            return when {
                matchingCount == 6 -> SIX
                matchingCount == 5 && isBonusCorrect -> FIFTH_WITH_BONUS
                matchingCount == 5 -> FIFTH
                matchingCount == 4 -> FOURTH
                matchingCount == 3 -> THREE
                else -> ZERO
            }
        }
    }
}
