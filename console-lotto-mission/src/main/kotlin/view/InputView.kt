package com.view

class InputView {

    fun inputBuyingPrice(): Int {
        println("구입 금액을 입력해주세요.")
        val price = readln().toInt()

        return price
    }

    fun inputLottoNumbers(): List<Int> {
        println("\n당첨 번호를 입력해 주세요.")
        val lottoNumbers = readln().split(",")
            .map { it.toInt() }
            .toList()

        return lottoNumbers
    }

    fun inputBonusNumber(): Int {
        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = readln().toInt()

        return bonusNumber
    }
}
