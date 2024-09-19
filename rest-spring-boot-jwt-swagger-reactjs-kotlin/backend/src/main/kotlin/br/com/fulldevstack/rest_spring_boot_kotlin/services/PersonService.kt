package br.com.fulldevstack.rest_spring_boot_kotlin.services
import br.com.fulldevstack.rest_spring_boot_kotlin.model.Person
import org.springframework.stereotype.Service
import java.util.logging.Logger
import java.util.concurrent.atomic.AtomicLong

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll() : List<Person> {
        logger.info("Finding All People!")

        val persons : MutableList<Person> = ArrayList()
        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)

        }
        return persons
    }

    fun findById(id: Long) : Person {
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Alexander"
        person.lastName = "Alves"
        person.address = "Nova Iguaçu - Rio de Janeiro - BR"
        person.gender = "Male"
        return person
    }

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {}

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Last Name $i"
        person.address = "Some Address in Brazil"
        person.gender = "Male"
        return person
    }
}