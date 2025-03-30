package co.kr.mbk1991.authserver.user.service

import co.kr.mbk1991.authserver.jwt.dto.JsonWebToken
import co.kr.mbk1991.authserver.oauth.dto.KakaoToken
import co.kr.mbk1991.authserver.user.dto.User
import co.kr.mbk1991.authserver.jwt.service.JwtService
import co.kr.mbk1991.authserver.oauth.dto.AuthCode
import co.kr.mbk1991.authserver.oauth.service.OAuthProviderRoutingService
import co.kr.mbk1991.authserver.util.RestUtil
import org.springframework.stereotype.Service

@Service
class UserService(val oAuthProviderRoutingService: OAuthProviderRoutingService,
                  val jwtService: JwtService) {
    fun redirectLoginPage(provider: String): String {
        return oAuthProviderRoutingService.redirectLoginPage(provider)
    }
    fun login(authCode: AuthCode): JsonWebToken {
        val oAuthToken = oAuthProviderRoutingService.getToken(authCode.provider, authCode.auth_code)
        println(oAuthToken)
        val userInfo = oAuthProviderRoutingService.getUserInfo(authCode.provider, oAuthToken)
        println(userInfo)
        return JsonWebToken("", "")
    }
    fun logout() {}
    private fun signin(user: User) {}
}
