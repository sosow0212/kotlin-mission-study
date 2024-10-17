package com.controller

import com.model.lotto.Lottos
import com.model.lotto.service.NumberGenerator
import com.model.manager.LottoManager
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
        val lottoManager = LottoManager.of(winningLottoNumbers, winningBonusNumber)

        val scores = lottos.calculateResult(
            lottoManager.getWinningLottoNumbers,
            lottoManager.winningBonusNumber
        )
        outputView.printLottosResult(LottoScoresResponse.of(scores, buyingPrice))
    }
}
