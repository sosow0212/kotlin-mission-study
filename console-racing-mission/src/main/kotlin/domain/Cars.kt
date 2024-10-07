package com.domain

import com.domain.service.NumberGenerator

class Cars private constructor(
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
        fun from(names: List<String>): Cars {
            val cars = names.map { Car.from(it) }
            return Cars(cars)
        }
    }
}
