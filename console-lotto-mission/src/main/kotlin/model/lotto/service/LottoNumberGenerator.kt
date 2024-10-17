package com.model.lotto.service

class LottoNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        return (START_NUMBER..END_NUMBER).shuffled()
            .take(QUANTITY)
            .sorted()
    }

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
        private const val QUANTITY = 6
    }
}
