package model

import com.model.NumberGenerator

class FakeNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return 5
    }
}
