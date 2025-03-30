package co.kr.mbk1991.authserver.user.dto

data class User(
    val idx: Long?,
    val userId: String,
    val email: String?,
    val nickName: String?,
    val profilePicture: String?,
    val loginMethod: String?,
    val listOpen: Int?,
    val createAt: String?,
    val updateAt: String?,
    val provider: String?
)
