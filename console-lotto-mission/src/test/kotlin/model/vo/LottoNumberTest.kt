package model.vo

import com.model.exception.LottoNumberInvalidException
import com.model.vo.LottoNumber
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 숫자는 1~46만 입력 가능하다`() {
        // given
        val wrongNumber = 100

        // when & then
        assertThatThrownBy {
            LottoNumber.from(wrongNumber)
        }.isInstanceOf(LottoNumberInvalidException::class.java)
    }
}
