package co.kr.mbk1991.authserver.user.controller

import co.kr.mbk1991.authserver.oauth.dto.AuthCode
import co.kr.mbk1991.authserver.jwt.dto.JsonWebToken
import co.kr.mbk1991.authserver.user.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class UserController(
    val userService: UserService,
) {
    @ResponseBody
    @GetMapping("/ping")
    fun ping(): String {
        return "pong"
    }
    @CrossOrigin
    @GetMapping("/api/auth/{provider}")
    fun redirectOAuthLoginPage(@PathVariable("provider") provider: String): String {
        return userService.redirectLoginPage(provider)
    }
    @CrossOrigin
    @PostMapping("/api/auth/login")
    fun login(@RequestBody authCode: AuthCode): JsonWebToken {
        return userService.login(authCode)
    }
}
