package com.view.response

import com.model.lotto.Lottos

data class LottoStatusResponse(
    val quantity: Int,
    val lottos: List<LottoNumberResponse>
) {
    companion object {
        fun from(lottos: Lottos): LottoStatusResponse {
            return LottoStatusResponse(
                quantity = lottos.lottos.size,
                lottos = lottos.lottos
                    .map { LottoNumberResponse.from(it) }
            )
        }
    }
}
