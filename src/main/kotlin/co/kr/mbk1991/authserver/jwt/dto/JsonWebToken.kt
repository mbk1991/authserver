package co.kr.mbk1991.authserver.jwt.dto

data class JsonWebToken(
    val token: String,
    val refresh_token: String,
)
