package com.model

import com.model.service.NumberGenerator

class Lotto private constructor(
    val lottos: List<Int>
) {
    fun calculateScore(winningNumbers: List<Int>, winningBonusNumber: Int): Score {
        return Score.of(lottos, winningNumbers, winningBonusNumber)
    }

    companion object {
        fun createDefault(numberGenerator: NumberGenerator): Lotto {
            val lottoNumbers = numberGenerator.generate()
            return Lotto(lottoNumbers)
        }
    }
}
