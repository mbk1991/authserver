package co.kr.mbk1991.authserver.auth.service

import co.kr.mbk1991.authserver.auth.dto.JsonWebToken
import co.kr.mbk1991.authserver.auth.dto.User
import org.springframework.stereotype.Service

@Service
class JwtService {
    fun createToken(user: User): JsonWebToken {
            TODO("Not yet implemented")
    }
}
