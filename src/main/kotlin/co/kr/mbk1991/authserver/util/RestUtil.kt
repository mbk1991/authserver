package co.kr.mbk1991.authserver.util

import co.kr.mbk1991.authserver.auth.dto.KakaoToken
import co.kr.mbk1991.authserver.auth.dto.User
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

object RestUtil {
    private val restTemplate: RestTemplate = RestTemplate()

    fun get(url: String): String {
       return restTemplate.getForObject(url)
    }

    fun kakaoTokenRequest(url: String, data: String, contentType: MediaType): ResponseEntity<KakaoToken> {
        val header = org.springframework.http.HttpHeaders()
        header.contentType = contentType
        val request = HttpEntity(data, header)
        val responseEntity: ResponseEntity<KakaoToken> =
            restTemplate.exchange(url, HttpMethod.POST, request, KakaoToken::class.java)

        return responseEntity
    }

    fun kakaoUserInfoRequest(kakaoToken: KakaoToken?): User {
        TODO("Not yet implemented")
    }
}
