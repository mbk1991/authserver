package co.kr.mbk1991.authserver.oauth.service

import co.kr.mbk1991.authserver.oauth.dto.OAuthToken

interface OAuthService {
    fun redirectLoginPage(provider: String): String
    fun getToken(provider: String, auth_code: String): OAuthToken
    fun chkToken(provider: String)
    fun getUserInfo(provider: String)
    fun logout(provider: String)

}
