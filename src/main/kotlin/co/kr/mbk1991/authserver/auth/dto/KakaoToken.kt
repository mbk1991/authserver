package co.kr.mbk1991.authserver.auth.dto

data class KakaoToken(
    val token_type: String,
    val access_token: String,
    val expires_in: String,
    val refresh_token: String,
    val refresh_token_expires_in: String,
    val scope: String
)
