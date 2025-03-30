package co.kr.mbk1991.authserver.util

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
    fun <T> post(url: String, data: String, contentType: MediaType, responseType: Class<T>): ResponseEntity<T> {
        val header = org.springframework.http.HttpHeaders()
        header.contentType = contentType
        val request = HttpEntity(data, header)
        return restTemplate.exchange(url, HttpMethod.POST, request, responseType)
    }

    fun <T> post(url: String, data: String, contentType: MediaType, token: String, responseType: Class<T>): ResponseEntity<T> {
        val header = org.springframework.http.HttpHeaders()
        header.contentType = contentType
        header.setBearerAuth(token)
        val request = HttpEntity(data, header)
        return restTemplate.exchange(url, HttpMethod.POST, request, responseType)
    }


}
