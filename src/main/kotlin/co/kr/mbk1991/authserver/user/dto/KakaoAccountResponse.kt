package co.kr.mbk1991.authserver.user.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class KakaoAccountResponse(
    val id: Long,
    val connectedAt: String?,
    val kakaoAccount: KakaoAccount?,
    val properties: Map<String, String>?,
    val forPartner: ForPartner?
) {
    data class KakaoAccount(
        @JsonProperty("profile_nickname_needs_agreement")
        val profileNicknameNeedsAgreement: Boolean?,

        @JsonProperty("profile_image_needs_agreement")
        val profileImageNeedsAgreement: Boolean?,

        val profile: Profile?,

        @JsonProperty("name_needs_agreement")
        val nameNeedsAgreement: Boolean?,

        val name: String?,

        @JsonProperty("email_needs_agreement")
        val emailNeedsAgreement: Boolean?,

        @JsonProperty("is_email_valid")
        val isEmailValid: Boolean?,

        @JsonProperty("is_email_verified")
        val isEmailVerified: Boolean?,

        val email: String?,

        @JsonProperty("age_range_needs_agreement")
        val ageRangeNeedsAgreement: Boolean?,

        val ageRange: String?,

        @JsonProperty("birthyear_needs_agreement")
        val birthyearNeedsAgreement: Boolean?,

        val birthyear: String?,

        @JsonProperty("birthday_needs_agreement")
        val birthdayNeedsAgreement: Boolean?,

        val birthday: String?,

        val birthdayType: String?,

        @JsonProperty("is_leap_month")
        val isLeapMonth: Boolean?,

        @JsonProperty("gender_needs_agreement")
        val genderNeedsAgreement: Boolean?,

        val gender: String?,

        @JsonProperty("phone_number_needs_agreement")
        val phoneNumberNeedsAgreement: Boolean?,

        val phoneNumber: String?,

        @JsonProperty("ci_needs_agreement")
        val ciNeedsAgreement: Boolean?,

        val ci: String?,

        @JsonProperty("ci_authenticated_at")
        val ciAuthenticatedAt: String?
    ) {
        data class Profile(
            val nickname: String?,
            @JsonProperty("thumbnail_image_url")
            val thumbnailImageUrl: String?,
            @JsonProperty("profile_image_url")
            val profileImageUrl: String?,

            @JsonProperty("is_default_image")
            val isDefaultImage: Boolean?,

            @JsonProperty("is_default_nickname")
            val isDefaultNickname: Boolean?
        )
    }

    data class ForPartner(
        val uuid: String?
    )
}
