package com.view.response

import com.model.lotto.Score

data class LottoScoresResponse(
    val scores: Map<String, Int>,
    val totalPrice: Double,
    val buyingPrice: Double,
) {
    companion object {
        fun of(
            lottoResults: List<Score>,
            buyingPrice: Int
        ): LottoScoresResponse {
            val scores = lottoResults.groupingBy { it.id }
                .eachCount()

            val totalPrice = lottoResults.sumOf { it.price.toDouble() }

            return LottoScoresResponse(scores, totalPrice, buyingPrice.toDouble())
        }
    }
}
