package com

import com.controller.LottoController
import com.model.service.LottoNumberGenerator
import com.view.InputView
import com.view.OutputView

fun main() {
    val lottoController = LottoController(
        InputView(),
        OutputView(),
        LottoNumberGenerator()
    )

    lottoController.run()
}
