package com.chskela.spring5webapp.repositories

import com.chskela.spring5webapp.domain.Publisher
import org.springframework.data.repository.CrudRepository

interface PublisherRepository : CrudRepository<Publisher, Long> {
}