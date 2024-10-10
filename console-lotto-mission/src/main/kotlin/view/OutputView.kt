package com.view

import com.view.response.LottoScoresResponse
import com.view.response.LottoStatusResponse

class OutputView {
    fun printLottosStatus(lottoStatusResponse: LottoStatusResponse) {
        println("\n${lottoStatusResponse.quantity}개를 구매했습니다.")

        lottoStatusResponse.lottos
            .forEach { println(it.lotto) }
    }

    fun printLottosResult(response: LottoScoresResponse) {
        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${response.scores["5등"] ?: 0}개")
        println("4개 일치 (50,000원) - ${response.scores["4등"] ?: 0}개")
        println("5개 일치 (1,500,000원) - ${response.scores["3등"] ?: 0}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000) - ${response.scores["2등"] ?: 0}개")
        println("6개 일치 (2,000,000,000원) - ${response.scores["1등"] ?: 0}개")
        println("총 수익률은 ${String.format("%.1f", calculateProfit(response.totalPrice, response.buyingPrice))}%입니다.")
    }

    private fun calculateProfit(totalPrice: Double, buyingPrice: Double): Double {
        return (totalPrice / buyingPrice) * 100
    }
}
