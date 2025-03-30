package co.kr.mbk1991.authserver.oauth.service

import co.kr.mbk1991.authserver.oauth.dto.OAuthToken
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GoogleOAuthService : OAuthService {
//    @Value("\${google.api.key}")
//    lateinit var API_KEY: String
//    @Value("\${google.api.redirect_url}")
//    lateinit var REDIRECT_URL: String
//    @Value("\${google.api.token.url}")
//    lateinit var TOKEN_URL: String
//    @Value("\${google.api.auth.url}")
//    lateinit var AUTH_URL: String
    override fun redirectLoginPage(provider: String): String {
        TODO("Not yet implemented")
    }

    override fun getToken(provider: String, auth_code: String): OAuthToken {
        TODO("Not yet implemented")
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
