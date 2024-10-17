package com.model.lotto

import com.model.exception.BuyingPriceInvalidException
import com.model.lotto.service.NumberGenerator
import com.model.vo.LottoNumber

class Lottos private constructor(
    val lottos: List<Lotto>
) {
    fun calculateResult(
        winningLottoNumber: List<LottoNumber>,
        winningBonusNumber: LottoNumber,
    ): List<Score> {
        return lottos.map { it.calculateScore(winningLottoNumber, winningBonusNumber) }
    }

    companion object {
        private const val PRICE_EACH_LOTTO = 1000

        fun from(
            price: Int,
            numberGenerator: NumberGenerator
        ): Lottos {
            validatePrice(price);
            val quantity = price / PRICE_EACH_LOTTO

            val lottos = List(quantity) {
                Lotto.createDefault(numberGenerator)
            }

            return Lottos(lottos)
        }

        private fun validatePrice(price: Int) {
            if (price % PRICE_EACH_LOTTO != 0) {
                throw BuyingPriceInvalidException()
            }
        }
    }
}
