package model

import com.model.lotto.Score
import com.model.vo.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class ScoreTest {

    @Test
    fun `1등 로또 상금을 찾는다`() {
        // given
        val myNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        val winningNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        val winningBonusNumber = LottoNumber.from(7)

        // when
        val score = Score.of(myNumbers, winningNumbers, winningBonusNumber)

        // then
        assertThat(score).isEqualTo(Score.SIX)
    }

    @Test
    fun `3개 이하는 꽝으로 처리한다`() {
        // given
        val myNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        val winningNumbers = listOf(
            LottoNumber.from(11),
            LottoNumber.from(12),
            LottoNumber.from(13),
            LottoNumber.from(14),
            LottoNumber.from(15),
            LottoNumber.from(16)
        )

        val winningBonusNumber = LottoNumber.from(7)

        // when
        val score = Score.of(myNumbers, winningNumbers, winningBonusNumber)

        // then
        assertThat(score).isEqualTo(Score.ZERO)
    }

    @Test
    fun `5개와 보너스 번호를 맞추면 준우승이다`() {
        // given
        val myNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(10)
        )

        val winningNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        val winningBonusNumber = LottoNumber.from(10)

        // when
        val score = Score.of(myNumbers, winningNumbers, winningBonusNumber)

        // then
        assertThat(score).isEqualTo(Score.FIFTH_WITH_BONUS)
    }
}
