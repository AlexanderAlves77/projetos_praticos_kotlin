package br.com.fulldevstack.rest_spring_boot_kotlin.services

import br.com.fulldevstack.rest_spring_boot_kotlin.controller.BookController
import br.com.fulldevstack.rest_spring_boot_kotlin.exceptions.RequiredObjectIsNullException
import br.com.fulldevstack.rest_spring_boot_kotlin.exceptions.ResourceNotFoundException
import br.com.fulldevstack.rest_spring_boot_kotlin.mapper.DozerMapper
import br.com.fulldevstack.rest_spring_boot_kotlin.model.Book
import br.com.fulldevstack.rest_spring_boot_kotlin.data.vo.v1.BookVO
import br.com.fulldevstack.rest_spring_boot_kotlin.repository.BookRepository
import br.com.fulldevstack.rest_spring_boot_kotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class UserService(@field:Autowired var repository: UserRepository) : UserDetailsService {

    private val logger = Logger.getLogger(UserService::class.java.name)

    override fun loadUserByUsername(username: String?): UserDetails {
        logger.info("Finding one User by Username ID $username!")
        val user = repository.findByUsername(username)
        return user ?: throw UsernameNotFoundException("Username $username not found!")
    }
}