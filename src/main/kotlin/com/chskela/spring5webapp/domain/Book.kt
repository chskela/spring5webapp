package com.chskela.spring5webapp.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    val title: String,
    val isbn: String,

    @ManyToOne
    val publisher: Publisher,

    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    val authors: Set<Author> = setOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Book

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , isbn = $isbn , authors = $authors)"
    }

}
