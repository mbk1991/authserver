package co.kr.mbk1991.authserver.jwt.service

import io.jsonwebtoken.ClaimJwtException
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.PrematureJwtException
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.SignatureException
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

class JwtServiceTest {

    @Test
    fun 엑세스토큰테스트() {
        var jwtService = JwtService()
        val token = jwtService.generateAccessToken("1")
        println(token)
    }

    @Test
    fun 엑세스토큰파싱테스트() {
        var jwtService = JwtService()
        val refreshToken = jwtService.generateAccessToken("1")
        println(refreshToken)
        jwtService.parseToken(refreshToken)
    }

    @Test
    fun 파싱테스트_시그니쳐(){
        var signatureErrToken = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NDM0NjE4MzIsImV4cCI6MTc0MzQ2NTQzMiwidXNlcklkIjoiMSJ9.cyNNd2xOTOG1Pn4htH5ShxgtyTPEzejn0BAvkSsEbBAs"

        var jwtService = JwtService()
        var exType = ""
        try{
            jwtService.parseToken(signatureErrToken)
        }catch(e: SignatureException){
            exType = "SignatureException"
        }catch(e: ExpiredJwtException){
            exType = "ExpiredJwtException"
        }catch(e: UnsupportedJwtException){
            exType = "UnsupportedJwtException"
        }catch(e: MalformedJwtException){
            exType = "MalformedJwtException"
        }catch(e: PrematureJwtException){
            exType = "PrematureJwtException"
        }catch(e: ClaimJwtException){
            exType = "ClaimJwtException"
        }
        assert(exType.equals("SignatureException"))
    }

    @Test
    fun 파싱테스트_유효기간초과(){
        var signatureErrToken = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NDM0NjI5MDksImV4cCI6MTc0MzQ1OTMwOSwidXNlcklkIjoiMSJ9.Y5Aq5ooEuCm-_AJrGlcEqAnM_PqI-NQ4EnfIBoqiEm4"
        var jwtService = JwtService()
        var exType = ""
        try{
            jwtService.parseToken(signatureErrToken)
        }catch(e: SignatureException){
            exType = "SignatureException"
        }catch(e: ExpiredJwtException){
            exType = "ExpiredJwtException"
        }catch(e: UnsupportedJwtException){
            exType = "UnsupportedJwtException"
        }catch(e: MalformedJwtException){
            exType = "MalformedJwtException"
        }catch(e: PrematureJwtException){
            exType = "PrematureJwtException"
        }catch(e: ClaimJwtException){
            exType = "ClaimJwtException"
        }
        assert(exType.equals("ExpiredJwtException"))
    }
}
