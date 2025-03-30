package co.kr.mbk1991.authserver.oauth.service

import co.kr.mbk1991.authserver.oauth.dto.KakaoToken
import co.kr.mbk1991.authserver.oauth.dto.OAuthToken
import co.kr.mbk1991.authserver.util.RestUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Service

@Service
class KakaoOAuthService : OAuthService {
    @Value("\${kakao.api.key}")
    lateinit var API_KEY: String
    @Value("\${kakao.api.redirect_url}")
    lateinit var REDIRECT_URL: String
    @Value("\${kakao.api.token.url}")
    lateinit var TOKEN_URL: String
    @Value("\${kakao.api.auth.url}")
    lateinit var AUTH_URL: String
    override fun redirectLoginPage(provider: String): String {
        return "redirect:${AUTH_URL}?client_id=${API_KEY}&redirect_uri=${REDIRECT_URL}&response_type=code&state=${provider}"
    }

    override fun getToken(provider: String, authCode: String): OAuthToken {
        val data = "grant_type=authorization_code&client_id=${API_KEY}&redirect_uri=${REDIRECT_URL}&code=${authCode}"
        return RestUtil.post( url = TOKEN_URL, data = data, MediaType.APPLICATION_FORM_URLENCODED, KakaoToken::class.java).body!!
    }

    override fun chkToken(provider: String) {
        TODO("Not yet implemented")
    }

    override fun getUserInfo(provider: String) {
        TODO("Not yet implemented")
    }

    override fun logout(provider: String) {
        TODO("Not yet implemented")
    }
}
