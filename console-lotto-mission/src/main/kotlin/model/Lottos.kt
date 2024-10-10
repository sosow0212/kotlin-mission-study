package com.model

import com.model.service.NumberGenerator

class Lottos private constructor(
    val lottos: List<Lotto>
) {
    fun calculateResult(
        winningLottoNumber: List<Int>,
        winningBonusNumber: Int
    ): List<Score> {
        val scores = lottos.map { it.calculateScore(winningLottoNumber, winningBonusNumber) }
            .toList()

        return scores
    }

    companion object {
        private const val PRICE_EACH_LOTTO = 1000

        fun from(price: Int, numberGenerator: NumberGenerator): Lottos {
            val quantity = price / PRICE_EACH_LOTTO

            val lottos = List(quantity) {
                Lotto.createDefault(numberGenerator)
            }

            return Lottos(lottos)
        }
    }
}
