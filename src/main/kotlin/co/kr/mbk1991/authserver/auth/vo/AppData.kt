package co.kr.mbk1991.authserver.auth.vo

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
@Component
class AppData {
    @Value("\${kakao.api.key}")
    lateinit var KAKAO_API_KEY: String
    @Value("\${kakao.api.redirect_url}")
    lateinit var KAKAO_API_REDIRECT_URL: String
    @Value("\${kakao.api.token.url}")
    lateinit var KAKAO_API_TOKEN_URL: String
    @Value("\${kakao.api.auth.url}")
    lateinit var KAKAO_API_AUTH_URL: String
}


