package br.com.fulldevstack.rest_spring_boot_kotlin.controller
import br.com.fulldevstack.rest_spring_boot_kotlin.data.vo.v1.PersonVO
import br.com.fulldevstack.rest_spring_boot_kotlin.data.vo.v2.PersonVO as PersonVOV2
import br.com.fulldevstack.rest_spring_boot_kotlin.services.PersonService
import br.com.fulldevstack.rest_spring_boot_kotlin.util.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/person/v1")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML])
    fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findById(@PathVariable(value = "id") id: Long): PersonVO {
        return service.findById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON])
    fun create(@RequestBody person: PersonVO): PersonVO {
        return service.create(person)
    }

    @PostMapping(value = ["/v2"], consumes = [MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON])
    fun createV2(@RequestBody person: PersonVOV2): PersonVOV2 {
        return service.createV2(person)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON])
    fun update(@RequestBody person: PersonVO): PersonVO {
        return service.update(person)
    }

    @DeleteMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML])
    fun delete(@PathVariable(value = "id") id: Long) : ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}