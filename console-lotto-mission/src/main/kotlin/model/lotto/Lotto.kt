package com.model.lotto

import com.model.lotto.service.NumberGenerator
import com.model.vo.LottoNumber

class Lotto private constructor(
    val lottos: List<LottoNumber>
) {
    fun calculateScore(winningNumbers: List<LottoNumber>, winningBonusNumber: LottoNumber): Score {
        return Score.of(lottos, winningNumbers, winningBonusNumber)
    }

    companion object {
        fun createDefault(numberGenerator: NumberGenerator): Lotto {
            val lottoNumbers = numberGenerator.generate()
                .map { LottoNumber.from(it) }

            return Lotto(lottoNumbers)
        }
    }
}
