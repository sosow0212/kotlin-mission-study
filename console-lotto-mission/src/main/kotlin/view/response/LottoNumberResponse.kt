package com.view.response

import com.model.lotto.Lotto
import com.model.vo.LottoNumber

data class LottoNumberResponse(
    val lotto: List<LottoNumber>
) {
    companion object {
        fun from(lotto: Lotto): LottoNumberResponse {
            return LottoNumberResponse(lotto.lottos)
        }
    }
}
