package br.com.fulldevstack.rest_spring_boot_kotlin.data.vo.v1

import java.util.*

data class TokenVO(
    var username: String? = null,
    var authenticated: Boolean? = null,
    var created: Date? = null,
    var expiration: Date? = null,
    var accessToken: String? = null,
    var refreshToken: String? = null
)
