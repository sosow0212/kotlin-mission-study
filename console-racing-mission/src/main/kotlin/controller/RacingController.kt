package com.controller

import com.domain.service.NumberGenerator
import com.model.Cars
import com.view.InputView
import com.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator
) {
    fun run() {
        val names = inputView.requestNames()
        val tryCount = inputView.requestTryCount()

        val cars = Cars.from(names)
        cars.moveCars(numberGenerator, tryCount)
        val winners = cars.findWinners();

        outputView.printResult(winners)
    }
}
