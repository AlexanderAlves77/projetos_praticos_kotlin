package br.com.fulldevstack.rest_spring_boot_kotlin.repository
import br.com.fulldevstack.rest_spring_boot_kotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository


interface PersonRepository : JpaRepository<Person, Long?> {


}