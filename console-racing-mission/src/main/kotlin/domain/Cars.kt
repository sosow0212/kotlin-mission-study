package com.model

import com.domain.exception.CarNameInvalidException
import com.domain.service.NumberGenerator

class Cars(
    private val cars: List<Car>
) {
    fun moveCars(numberGenerator: NumberGenerator, tryCount: Int) {
        for (i in 0 until tryCount) {
            this.cars.forEach { it.move(numberGenerator) }
        }
    }

    fun findWinners(): List<String> {
        val maxMoveCount = cars.maxOf { it.moveCount }

        return cars.filter { it.isSameMoveCount(maxMoveCount) }
            .map { it.name }
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5

        fun from(names: List<String>): Cars {
            validateNames(names)
            val cars = names.map { Car(it) }
            return Cars(cars)
        }

        private fun validateNames(carNames: List<String>) {
            carNames.forEach { validateNameLength(it) }
        }

        private fun validateNameLength(name: String) {
            if (name.length >= NAME_LENGTH_LIMIT) {
                throw CarNameInvalidException()
            }
        }
    }
}
