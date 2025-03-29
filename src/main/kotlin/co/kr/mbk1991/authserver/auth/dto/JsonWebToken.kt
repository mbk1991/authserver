package co.kr.mbk1991.authserver.auth.dto

data class JsonWebToken(
    val token: String,
    val refresh_token: String,
)
