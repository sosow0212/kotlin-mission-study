package com.model

class Car(
    val name: String,
) {
    companion object {
        private const val DEFAULT_MOVE_COUNT: Int = 0
        private const val MINIMUM_NUMBER_TO_MOVE_CAR: Int = 4;
    }

    var moveCount: Int = DEFAULT_MOVE_COUNT

    fun move(numberGenerator: NumberGenerator) {
        if (numberGenerator.generate() >= MINIMUM_NUMBER_TO_MOVE_CAR) {
            moveCount++
        }
    }
}
