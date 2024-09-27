package domain

import com.model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `숫자가 4이상이면 자동차는 움직인다`() {
        // given
        val car = Car("jay")
        val defaultCount = car.moveCount

        // when
        car.move(FakeNumberGenerator())

        // then
        assertThat(car.moveCount).isEqualTo(defaultCount + 1);
    }
}
