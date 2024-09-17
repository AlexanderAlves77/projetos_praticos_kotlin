package br.com.fulldevstack.rest_spring_boot_kotlin.mapper.custom
import br.com.fulldevstack.rest_spring_boot_kotlin.data.vo.v2.PersonVO as PersonVOV2
import br.com.fulldevstack.rest_spring_boot_kotlin.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person) : PersonVOV2 {
        val vo = PersonVOV2()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.address = person.address
        vo.gender = person.gender
        vo.birthDay = Date()
        return vo
    }

    fun mapVOToEntity(person: PersonVOV2) : Person {
        val entity = Person()
        entity.id = person.id
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        // entity.birthDay = Date()
        return entity
    }
}