package com

import com.controller.RacingController
import com.domain.service.RandomNumberGenerator
import com.view.InputView
import com.view.OutputView

fun main() {
    RacingController(
        InputView(),
        OutputView(),
        RandomNumberGenerator()
    ).run()
}
