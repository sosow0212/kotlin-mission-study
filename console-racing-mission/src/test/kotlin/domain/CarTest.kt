package domain

import com.domain.Car
import com.domain.exception.CarNameInvalidException
import domain.service.FakeNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `숫자가 4이상이면 자동차는 움직인다`() {
        // given
        val car = Car.from("jay")
        val defaultCount = car.moveCount

        // when
        car.move(FakeNumberGenerator())

        // then
        assertThat(car.moveCount).isEqualTo(defaultCount + 1);
    }

    @Test
    fun `움직인 수가 같으면 true를 반환한다`() {
        // given
        val car = Car.from("jay")
        val moveCount = car.moveCount

        // when
        val result = car.isSameMoveCount(moveCount)

        // then
        assertThat(result).isTrue()
    }

    @Test
    fun `이름의 길이가 5 이상이면 예외를 발생한다`() {
        // given
        val name: String = "fiveLengthOfNames"

        // when & then
        assertThatThrownBy {
            Car.from(name)
        }.isInstanceOf(CarNameInvalidException::class.java)
    }
}
