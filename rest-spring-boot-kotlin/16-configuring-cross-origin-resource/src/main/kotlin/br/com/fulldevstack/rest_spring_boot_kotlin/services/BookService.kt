package br.com.fulldevstack.rest_spring_boot_kotlin.services

import br.com.fulldevstack.rest_spring_boot_kotlin.controller.BookController
import br.com.fulldevstack.rest_spring_boot_kotlin.exceptions.RequiredObjectIsNullException
import br.com.fulldevstack.rest_spring_boot_kotlin.exceptions.ResourceNotFoundException
import br.com.fulldevstack.rest_spring_boot_kotlin.mapper.DozerMapper
import br.com.fulldevstack.rest_spring_boot_kotlin.model.Book
import br.com.fulldevstack.rest_spring_boot_kotlin.data.vo.v1.BookVO
import br.com.fulldevstack.rest_spring_boot_kotlin.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class BookService {

    @Autowired
    private lateinit var repository: BookRepository

    private val logger = Logger.getLogger(BookService::class.java.name)

    fun findAll() : List<BookVO> {
        logger.info("Finding All People!")
        val books = repository.findAll()
        val vos =  DozerMapper.parseListObjects(books, BookVO::class.java)
        for (book in vos) {
            val withSelfRel = linkTo(BookController::class.java).slash(book.key).withSelfRel()
            book.add(withSelfRel)
        }
        return vos
    }

    fun findById(id: Long) : BookVO {
        logger.info("Finding one person with ID $id!")
        var book = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        val bookVO: BookVO = DozerMapper.parseObject(book, BookVO::class.java)
        val withSelfRel = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRel)
        return bookVO
    }

    fun create(book: BookVO) : BookVO {
        if (book == null) throw RequiredObjectIsNullException()
        logger.info("Creating one person with name ${book.title}!")
        var entity: Book = DozerMapper.parseObject(book, Book::class.java)
        val bookVO: BookVO =  DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
        val withSelfRel = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRel)
        return bookVO
    }
    /*
    fun createV2(person: PersonVOV2) : PersonVOV2 {
        logger.info("Creating one person with name ${person.firstName}!")
        var entity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntityToVO(repository.save(entity))
    } */

    fun update(book: BookVO) : BookVO {
        if (book == null) throw RequiredObjectIsNullException()
        logger.info("Updating one person with ID ${book.key}!")
        val entity = repository.findById(book.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        entity.author = book.author
        entity.launchDate = book.launchDate
        entity.price = book.price
        entity.title = book.title

        val bookVO: BookVO =  DozerMapper.parseObject(repository.save(entity), BookVO::class.java)
        val withSelfRel = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRel)
        return bookVO
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }

}