package com.chskela.spring5webapp.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    val firstName: String,
    val lastName: String,

    @ManyToMany(mappedBy = "authors")
    val books: Set<Book> = setOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Author

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , firstName = $firstName , lastName = $lastName , books = $books )"
    }

}
