package co.kr.mbk1991.authserver.jwt.dto

data class JwtPayload (
    val iat: String,
    val exp: String,
    val userId: String?
)
