package com.chskela.spring5webapp.bootstrap

import com.chskela.spring5webapp.domain.Author
import com.chskela.spring5webapp.domain.Book
import com.chskela.spring5webapp.domain.Publisher
import com.chskela.spring5webapp.repositories.AuthorRepository
import com.chskela.spring5webapp.repositories.BookRepository
import com.chskela.spring5webapp.repositories.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootStrapData(
    private val authorRepository: AuthorRepository,
    private val bookRepository: BookRepository,
    private val publisherRepository: PublisherRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("Started in BootStrap")

        val publisher = Publisher(name = "SFG", city = "SPB", state = "FL")

        publisherRepository.save(publisher)

        val eric = Author(firstName = "Eric", lastName = "Evans")
        val ddd = Book(title = "DDD", isbn = "123123", publisher = publisher)
        eric.books.plus(ddd)
        ddd.authors.plus(eric)

        authorRepository.save(eric)
        bookRepository.save(ddd)

        val rod = Author(firstName = "Rod", lastName = "Johnson")
        val noEJB = Book(title = "J2EE", isbn = "654651116584", publisher = publisher)
        rod.books.plus(noEJB)
        noEJB.authors.plus(rod)

        authorRepository.save(rod)
        bookRepository.save(noEJB)

        publisher.books.plus(setOf(ddd, noEJB))
        publisherRepository.save(publisher)

        println("Number of Publishers: ${publisherRepository.count()}")
        println("Number of Authors: ${authorRepository.count()}")
        println("Number of Books: ${bookRepository.count()}")
    }
}