package co.kr.mbk1991.authserver.oauth.service

import co.kr.mbk1991.authserver.oauth.dto.OAuthToken
import co.kr.mbk1991.authserver.user.dto.GoogleAccountResponse
import co.kr.mbk1991.authserver.user.dto.KakaoAccountResponse
import co.kr.mbk1991.authserver.user.dto.User
import org.springframework.stereotype.Service

@Service
class OAuthProviderRoutingService(
    val kakaoOAuthService: KakaoOAuthService,
    val googleOAuthService: GoogleOAuthService
) {

    fun redirectLoginPage(provider: String): String {
        when (provider) {
            "kakao" -> return kakaoOAuthService.redirectLoginPage()
            "google" -> return googleOAuthService.redirectLoginPage()
            else -> throw Exception("no provider")
        }
    }

    fun getToken(provider: String, authCode: String): OAuthToken {
        when (provider) {
            "kakao" -> return kakaoOAuthService.getToken(authCode)
            "google" -> return googleOAuthService.getToken(authCode)
            else -> throw Exception("no provider")
        }
    }

    fun chkToken(provider: String) {
        TODO("Not yet implemented")
    }

    fun getUserInfo(provider: String, oAuthToken: OAuthToken): User {
        when (provider) {
            "kakao" -> return kakaoOAuthService.getUserInfo(oAuthToken)
            "google" -> return googleOAuthService.getUserInfo(oAuthToken)
            else -> throw Exception("no provider")
        }
    }

    fun logout(provider: String) {
        TODO("Not yet implemented")
    }
}
