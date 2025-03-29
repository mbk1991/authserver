package co.kr.mbk1991.authserver.auth.controller

import co.kr.mbk1991.authserver.auth.dto.AuthCode
import co.kr.mbk1991.authserver.auth.dto.JsonWebToken
import co.kr.mbk1991.authserver.auth.service.AuthService
import co.kr.mbk1991.authserver.auth.vo.AppData
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class AuthController(val authService: AuthService, val appData: AppData) {
    @ResponseBody
    @GetMapping("/ping")
    fun ping(): String {
        return "pong"
    }

    @CrossOrigin
    @GetMapping("/api/auth/kakao")
    fun kakaoLoginRequest(): String {

        println("authUrl" + appData.KAKAO_API_AUTH_URL)

        return "redirect:${appData.KAKAO_API_AUTH_URL}?client_id=${appData.KAKAO_API_KEY}" +
                "&redirect_uri=${appData.KAKAO_API_REDIRECT_URL}&response_type=code"
    }

    @CrossOrigin
    @PostMapping("/api/auth/login")
    fun login(@RequestBody authCode: AuthCode): JsonWebToken {
        return authService.login(authCode.auth_code)
    }
}
