package com.chskela.spring5webapp.repositories

import com.chskela.spring5webapp.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {
}