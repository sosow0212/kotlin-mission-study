package model

import com.model.lotto.service.NumberGenerator

class FakeNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
