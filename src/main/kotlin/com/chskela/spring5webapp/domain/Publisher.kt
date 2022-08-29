package com.chskela.spring5webapp.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    val id: Long? = null,
    val name: String,
    val addressLine: String = "",
    val city: String = "",
    val state: String = "",
    val zip: String = "",

    @OneToMany
    @JoinColumn(name = "publisher_id")
    val books: Set<Book> = setOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Publisher

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , addressLine = $addressLine , city = $city , state = $state , zip = $zip )"
    }


}
