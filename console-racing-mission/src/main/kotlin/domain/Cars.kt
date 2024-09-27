package com.model

import com.domain.exception.CarNameInvalidException
import com.domain.service.NumberGenerator

class Cars(
    carNames: List<String>,
) {
    private val cars: List<Car>

    init {
        validateNames(carNames)
        this.cars = carNames.map { Car(it) }
    }

    private fun validateNames(carNames: List<String>) {
        carNames.forEach { validateNameLength(it) }
    }

    private fun validateNameLength(name: String) {
        if (name.length >= NAME_LENGTH_LIMIT) {
            throw CarNameInvalidException()
        }
    }

    fun moveCars(numberGenerator: NumberGenerator) {
        this.cars.forEach { it.move(numberGenerator) }
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
    }
}
