package co.kr.mbk1991.authserver.oauth.service

import co.kr.mbk1991.authserver.oauth.dto.KakaoToken
import co.kr.mbk1991.authserver.oauth.dto.OAuthToken
import co.kr.mbk1991.authserver.user.dto.KakaoAccountResponse
import co.kr.mbk1991.authserver.user.dto.User
import co.kr.mbk1991.authserver.util.RestUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Service

@Service
class KakaoOAuthService {
    @Value("\${kakao.api.key}")
    lateinit var API_KEY: String

    @Value("\${kakao.api.redirect_url}")
    lateinit var REDIRECT_URL: String

    @Value("\${kakao.api.token.url}")
    lateinit var TOKEN_URL: String

    @Value("\${kakao.api.auth.url}")
    lateinit var AUTH_CODE_URL: String

    @Value("\${kakao.api.user.me}")
    lateinit var USER_INFO_URL: String
    fun redirectLoginPage(): String {
        return "redirect:${AUTH_CODE_URL}?client_id=${API_KEY}" +
                "&redirect_uri=${REDIRECT_URL}&response_type=code&state=kakao"
    }

    fun getToken(authCode: String): OAuthToken {
        val data = "grant_type=authorization_code&client_id=${API_KEY}" +
                "&redirect_uri=${REDIRECT_URL}&code=${authCode}"

        return RestUtil.post(
            url = TOKEN_URL,
            data = data,
            contentType = MediaType.APPLICATION_FORM_URLENCODED,
            responseType = KakaoToken::class.java
        ).body!!
    }

    fun chkToken(provider: String) {
        TODO("Not yet implemented")
    }

    fun getUserInfo(oAuthToken: OAuthToken): User {
        return setUser(RestUtil.post(
            url = USER_INFO_URL,
            data = "",
            contentType = MediaType.APPLICATION_FORM_URLENCODED,
            token = oAuthToken.access_token,
            responseType = KakaoAccountResponse::class.java
        ).body!!)
    }

    private fun setUser(body: KakaoAccountResponse): User {
        TODO("Not yet implemented")

    }

    fun logout(provider: String) {
        TODO("Not yet implemented")
    }
}
