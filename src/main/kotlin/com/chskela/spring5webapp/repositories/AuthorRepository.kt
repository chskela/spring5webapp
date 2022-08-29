package com.chskela.spring5webapp.repositories

import com.chskela.spring5webapp.domain.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Long> {
}