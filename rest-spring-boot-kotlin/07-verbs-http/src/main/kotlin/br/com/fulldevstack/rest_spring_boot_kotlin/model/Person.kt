package br.com.fulldevstack.rest_spring_boot_kotlin.model

data class Person(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
)