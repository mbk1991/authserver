package co.kr.mbk1991.authserver.jwt.service

import io.jsonwebtoken.Jwt
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties
import org.springframework.stereotype.Service
import java.security.Key
import java.security.PublicKey
import java.util.*
import javax.crypto.SecretKey


@Service
class JwtService {
    //    @Value("\${jwt.secret}")
//    lateinit var secret: String
    var secret: String = "hotspotspothot12345asdfgqwertzxcvpoiugkttmvktggktqksl"

    //    @Value("\${jwt.exp.time.hour}")
//    lateinit var accssExpHour: String
    var accssExpHour: String = "1"

    //    @Value("\${jwt.refrsh.exp.time.day}")
//    lateinit var accssRefreshExpDay: String
    var accssRefreshExpDay: String = "3"

    fun generateAccessToken(userId: String): String {
        var exp = Date(
            System.currentTimeMillis() +
                    (accssExpHour.toInt() * 1_000 * 60 * 60)
        )
        return Jwts.builder()
            .issuedAt(Date())
            .expiration(exp)
            .claim("userId", userId)
            .signWith(getSecretKey())
            .compact()
    }

    fun generateRefreshToken(): String{
        var exp = Date(
            System.currentTimeMillis() +
                    (accssRefreshExpDay.toInt() * 1_000 * 60 * 60 * 24)
        )
        return Jwts.builder()
            .issuedAt(Date())
            .expiration(exp)
            .signWith(getSecretKey())
            .compact()
    }

    fun parseToken(token: String) {
        var secretKey = Jwts.SIG.HS512.key().build()

        val parseSignedClaims = Jwts.parser()
            .verifyWith(getSecretKey())
            .build()
            .parseSignedClaims(token)

        println(parseSignedClaims.toString())
    }

    private fun getSecretKey(): SecretKey {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(this.secret))
    }
}
