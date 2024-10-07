package com.view

class InputView {
    fun requestNames(): List<String> {
        println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분")
        return readln().split(NAME_SPLIT_DELIMITER)
            .stream()
            .map { it.trim() }
            .toList()
    }

    fun requestTryCount(): Int {
        println("경기 시도 횟수를 입력")
        return readln().toInt()
    }

    companion object {
        const val NAME_SPLIT_DELIMITER = ","
    }
}
