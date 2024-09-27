package domain

import com.domain.exception.CarNameInvalidException
import com.model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CarsTest {

    @DisplayName("자동차 생성 테스트")
    @Nested
    inner class CreateCarTest {
        @Test
        fun `이름의 길이가 5 이상이라면 예외를 발생시킨다`() {
            // given
            val carNames = listOf("coconut", "popups")

            // when & then
            assertThatThrownBy {
                Cars.from(carNames)
            }.isInstanceOf(CarNameInvalidException::class.java)
        }

        @Test
        fun `이름의 길이가 정상이라면 정상 생성된다`() {
            // given
            val carNames = listOf("lee", "eom")

            // when & then
            assertDoesNotThrow {
                Cars.from(carNames)
            }
        }
    }

    @Test
    fun `우승자를 찾는다`() {
        // given
        val cars = Cars.from(listOf("lee", "eom"))

        // when
        val result = cars.findWinners()

        // then
        assertThat(result).containsAll(listOf("lee", "eom"))
     }
}
