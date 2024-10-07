package com.view

class OutputView {
    fun printResult(winners: List<String>) {
        val result = winners.joinToString(", ") { it }
        println("최종 우승자 : $result")
    }
}
