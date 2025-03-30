package co.kr.mbk1991.authserver.oauth.dto

open class OAuthToken(
    val token_type: String,
    val access_token: String,
    val expires_in: String,
    val refresh_token: String,
    val refresh_token_expires_in: String,
    val scope: String
)
