package model.manager

import com.model.exception.LottoNumberInvalidException
import com.model.manager.WinningLottoNumbers
import org.assertj.core.api.Assertions.assertThatThrownBy
import kotlin.test.Test

class WinningLottoNumbersTest {

    @Test
    fun `1~46가 아닌 숫자가 포함되면 예외륿 발생시킨다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 100, 200)

        // when & then
        assertThatThrownBy {
            WinningLottoNumbers.from(numbers)
        }.isInstanceOf(LottoNumberInvalidException::class.java)
    }
}
