package co.kr.mbk1991.authserver.auth.service

import co.kr.mbk1991.authserver.auth.dto.JsonWebToken
import co.kr.mbk1991.authserver.auth.dto.KakaoToken
import co.kr.mbk1991.authserver.auth.dto.User
import co.kr.mbk1991.authserver.auth.vo.AppData
import co.kr.mbk1991.authserver.util.RestUtil
import org.springframework.http.MediaType
import org.springframework.stereotype.Service

@Service
class AuthService(val jwtService: JwtService, val appData: AppData) {
    fun login(authCode: String): JsonWebToken {
        var jsonWebToken: JsonWebToken
        val data = "grant_type=authorization_code&client_id=${appData.KAKAO_API_KEY}&redirect_uri=${appData.KAKAO_API_REDIRECT_URL}&code=${authCode}"
        val kakaoToken: KakaoToken? = RestUtil.kakaoTokenRequest(
            url = appData.KAKAO_API_TOKEN_URL, data = data, MediaType.APPLICATION_FORM_URLENCODED
        ).body

        println(kakaoToken)
        val user: User = getKakaoUserInfo(kakaoToken)
        //처음 접속하는 유저 가입 처리
        //기존 유저 업데이트 처리

        jsonWebToken = jwtService.createToken(user)

        return jsonWebToken
    }

    private fun getKakaoUserInfo(kakaoToken: KakaoToken?): User {
        return RestUtil.kakaoUserInfoRequest(kakaoToken)
    }

    private fun signin(user: User) {

    }
}
