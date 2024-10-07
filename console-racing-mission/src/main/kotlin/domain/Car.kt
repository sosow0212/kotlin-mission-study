package com.domain

import com.domain.exception.CarNameInvalidException
import com.domain.service.NumberGenerator

class Car private constructor(
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
        private const val NAME_LENGTH_LIMIT = 5

        fun from(name: String): Car {
            validateName(name)
            return Car(name)
        }

        private fun validateName(name: String) {
            if (name.length >= NAME_LENGTH_LIMIT) {
                throw CarNameInvalidException()
            }
        }
    }
}
