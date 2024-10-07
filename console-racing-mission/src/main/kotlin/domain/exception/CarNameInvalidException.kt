package com.domain.exception

class CarNameInvalidException : RuntimeException(
    "자동차 이름의 길이는 5 미만이어야 합니다."
) {
}
