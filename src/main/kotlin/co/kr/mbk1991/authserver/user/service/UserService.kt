package co.kr.mbk1991.authserver.user.service

import co.kr.mbk1991.authserver.jwt.dto.JsonWebToken
import co.kr.mbk1991.authserver.oauth.dto.KakaoToken
import co.kr.mbk1991.authserver.user.dto.User
import co.kr.mbk1991.authserver.jwt.service.JwtService
import co.kr.mbk1991.authserver.oauth.dto.AuthCode
import co.kr.mbk1991.authserver.util.RestUtil
import org.springframework.stereotype.Service

@Service
class UserService(val jwtService: JwtService) {
    fun login(authCode: AuthCode): JsonWebToken {
        return JsonWebToken("","")
    }

    private fun getKakaoUserInfo(kakaoToken: KakaoToken?): User {
        return RestUtil.kakaoUserInfoRequest(kakaoToken)
    }

    private fun signin(user: User) {

    }
}
