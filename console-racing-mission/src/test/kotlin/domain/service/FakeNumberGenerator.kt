package domain.service

import com.domain.service.NumberGenerator

class FakeNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return 5
    }
}
