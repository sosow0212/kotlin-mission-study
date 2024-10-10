package model

import com.model.Lottos
import com.model.Score
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertEquals

class LottosTest {

    @Test
    fun `로또가 10장 생성된다`() {
        // given
        val price: Int = 10000;

        // when
        val result = Lottos.from(price, FakeNumberGenerator())

        // then
        assertThat(result.lottos.size).isEqualTo(10)
    }

    @Test
    fun `스코어를 나열한다`() {
        // given
        val lottos = Lottos.from(1000, FakeNumberGenerator())
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // when
        val result = lottos.calculateResult(winningNumbers, bonusNumber)

        // then
        assertAll(
            Executable { assertEquals(result.size, 1) },
            Executable { assertEquals(result.get(0), Score.SIX) },
        );

    }
}
