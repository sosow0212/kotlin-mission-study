package model

import com.model.Score
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class ScoreTest {

    @Test
    fun `1등 로또 상금을 찾는다`() {
        // given
        val myNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningBonusNumber = 7

        // when
        val score = Score.of(myNumbers, winningNumbers, winningBonusNumber)

        // then
        assertThat(score).isEqualTo(Score.SIX)
    }

    @Test
    fun `3개 이하는 꽝으로 처리한다`() {
        // given
        val myNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(11, 12, 13, 14, 15, 16)
        val winningBonusNumber = 7

        // when
        val score = Score.of(myNumbers, winningNumbers, winningBonusNumber)

        // then
        assertThat(score).isEqualTo(Score.ZERO)
    }

    @Test
    fun `5개와 보너스 번호를 맞추면 준우승이다`() {
        // given
        val myNumbers = listOf(1, 2, 3, 4, 5, 7)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningBonusNumber = 7

        // when
        val score = Score.of(myNumbers, winningNumbers, winningBonusNumber)

        // then
        assertThat(score).isEqualTo(Score.FIFTH_WITH_BONUS)
    }
}
