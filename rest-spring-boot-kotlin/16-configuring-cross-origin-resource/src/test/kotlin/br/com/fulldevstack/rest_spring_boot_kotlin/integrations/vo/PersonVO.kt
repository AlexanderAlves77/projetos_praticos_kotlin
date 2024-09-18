package br.com.fulldevstack.rest_spring_boot_kotlin.integrations.vo

import org.springframework.hateoas.RepresentationModel


data class PersonVO(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
) : RepresentationModel<PersonVO>()