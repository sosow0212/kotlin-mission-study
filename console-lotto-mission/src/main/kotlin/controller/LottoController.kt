package com.controller

import com.model.Lottos
import com.model.service.NumberGenerator
import com.view.InputView
import com.view.OutputView
import com.view.response.LottoScoresResponse
import com.view.response.LottoStatusResponse

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator,
) {
    fun run() {
        val buyingPrice = inputView.inputBuyingPrice()
        val lottos = Lottos.from(buyingPrice, numberGenerator)
        outputView.printLottosStatus(LottoStatusResponse.from(lottos))

        val winningLottoNumbers = inputView.inputLottoNumbers()
        val winningBonusNumber = inputView.inputBonusNumber()
        val scores = lottos.calculateResult(winningLottoNumbers, winningBonusNumber)
        outputView.printLottosResult(LottoScoresResponse.of(scores, buyingPrice))
    }
}
