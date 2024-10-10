package model

import com.model.service.LottoNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {

    @Test
    fun `숫자를 1부터 45까지 랜덤으로 6개를 뽑는다`() {
        // given
        val generator = LottoNumberGenerator()

        // when
        val result = generator.generate()

        // then
        assertThat(result.size).isEqualTo(6)
    }
}
