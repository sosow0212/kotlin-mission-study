package domain

import com.domain.Car
import domain.service.FakeNumberGenerator
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

    @Test
    fun `움직인 수가 같으면 true를 반환한다`() {
        // given
        val car = Car("jay")
        val moveCount = car.moveCount

        // when
        val result = car.isSameMoveCount(moveCount)

        // then
        assertThat(result).isTrue()
    }
}
