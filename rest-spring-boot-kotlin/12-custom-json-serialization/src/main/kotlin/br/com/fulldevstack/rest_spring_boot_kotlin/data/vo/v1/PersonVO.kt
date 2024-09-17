package br.com.fulldevstack.rest_spring_boot_kotlin.data.vo.v1
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("id", "first_name", "last_name", "address", "gender")
data class PersonVO(
    var id: Long = 0,

    @field:JsonPropertyOrder("first_name")
    var firstName: String = "",

    @field:JsonPropertyOrder("last_name")
    var lastName: String = "",
    var address: String = "",
    //@field:JsonIgnore
    var gender: String = ""
)