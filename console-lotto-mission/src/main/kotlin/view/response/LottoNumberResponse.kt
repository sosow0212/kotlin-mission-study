package com.view.response

import com.model.Lotto

data class LottoNumberResponse private constructor(
    val lotto: List<Int>
) {
    companion object {
        fun from(lotto: Lotto): LottoNumberResponse {
            return LottoNumberResponse(lotto.lottos)
        }
    }
}
