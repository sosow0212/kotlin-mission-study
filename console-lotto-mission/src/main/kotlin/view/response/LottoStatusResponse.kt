package com.view.response

import com.model.Lottos

data class LottoStatusResponse(
    val quantity: Int,
    val lottos: List<LottoNumberResponse>
) {
    companion object {
        fun from(lottos: Lottos): LottoStatusResponse {
            return LottoStatusResponse(
                lottos.lottos.size,
                lottos.lottos.stream()
                    .map { LottoNumberResponse.from(it) }
                    .toList()
            )
        }
    }
}
