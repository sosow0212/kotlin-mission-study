package com.model

import com.domain.service.NumberGenerator

class Car(
    val name: String,
) {
    var moveCount: Int = DEFAULT_MOVE_COUNT
        private set

    fun move(numberGenerator: NumberGenerator) {
        if (numberGenerator.generate() >= MINIMUM_NUMBER_TO_MOVE_CAR) {
            this.moveCount++
        }
    }

    fun isSameMoveCount(count: Int): Boolean {
        return this.moveCount == count
    }

    companion object {
        private const val DEFAULT_MOVE_COUNT: Int = 0
        private const val MINIMUM_NUMBER_TO_MOVE_CAR: Int = 4
    }
}
