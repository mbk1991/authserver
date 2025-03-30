package co.kr.mbk1991.authserver.user.dto

data class KakaoAccountResponse(
    val id: Long,
    val connected_at: String?,
    val kakao_account: KakaoAccount?,
    val properties: Map<String, String>?,
    val for_partner: ForPartner?
) {
    data class KakaoAccount(
        val profile_nickname_needs_agreement: Boolean?,
        val profile_image_needs_agreement: Boolean?,
        val profile: Profile?,
        val name_needs_agreement: Boolean?,
        val name: String?,
        val email_needs_agreement: Boolean?,
        val is_email_valid: Boolean?,
        val is_email_verified: Boolean?,
        val email: String?,
        val age_range_needs_agreement: Boolean?,
        val age_range: String?,
        val birthyear_needs_agreement: Boolean?,
        val birthyear: String?,
        val birthday_needs_agreement: Boolean?,
        val birthday: String?,
        val birthday_type: String?,
        val is_leap_month: Boolean?,
        val gender_needs_agreement: Boolean?,
        val gender: String?,
        val phone_number_needs_agreement: Boolean?,
        val phone_number: String?,
        val ci_needs_agreement: Boolean?,
        val ci: String?,
        val ci_authenticated_at: String?
    ) {
        data class Profile(
            val nickname: String?,
            val thumbnail_image_url: String?,
            val profile_image_url: String?,
            val is_default_image: Boolean?,
            val is_default_nickname: Boolean?
        )
    }

    data class ForPartner(
        val uuid: String?
    )
}
