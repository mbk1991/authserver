package co.kr.mbk1991.authserver.oauth.dto

class GoogleToken(
    token_type: String,
    access_token: String,
    expires_in: String,
    refresh_token: String,
    refresh_token_expires_in: String,
    scope: String
) : OAuthToken(token_type, access_token, expires_in, refresh_token, refresh_token_expires_in, scope)
