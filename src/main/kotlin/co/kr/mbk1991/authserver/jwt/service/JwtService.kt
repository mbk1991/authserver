package co.kr.mbk1991.authserver.jwt.service

import co.kr.mbk1991.authserver.jwt.dto.JsonWebToken
import co.kr.mbk1991.authserver.user.dto.User
import org.springframework.stereotype.Service

@Service
class JwtService {
    fun createToken(user: User): JsonWebToken {
            TODO("Not yet implemented")
    }
}
