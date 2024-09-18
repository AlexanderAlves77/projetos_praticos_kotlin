package br.com.fulldevstack.rest_spring_boot_kotlin.repository

import br.com.fulldevstack.rest_spring_boot_kotlin.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long?>