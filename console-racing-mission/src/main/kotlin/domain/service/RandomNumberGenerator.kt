package com.domain.service

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(START_NUMBER, END_NUMBER)
    }

    companion object {
        private const val START_NUMBER = 0
        private const val END_NUMBER = 10
    }
}
