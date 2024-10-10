package model

import com.model.exception.BuyingPriceInvalidException
import com.model.lotto.Lottos
import com.model.lotto.Score
import com.model.vo.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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

        val winningNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )
        val bonusNumber = LottoNumber.from(7)

        // when
        val result = lottos.calculateResult(winningNumbers, bonusNumber)

        // then
        assertAll(
            Executable { assertEquals(result.size, 1) },
            Executable { assertEquals(result.get(0), Score.SIX) },
        )
    }

    @Test
    fun `로또 구입 금액은 1000원 단위로 입력한다`() {
        // when & then
        assertThatThrownBy {
            Lottos.from(1100, FakeNumberGenerator())
        }.isInstanceOf(BuyingPriceInvalidException::class.java)
    }
}
