package com.rahul.quora.clone.data

import jakarta.persistence.*

/*
 Always provide the default value to each field in the entity class
 Reason: JPA (Java Persistence API), a default (no-argument) constructor is required for entity classes because
 JPA uses reflection to instantiate these entities.
 */
@Entity
@Table(name = "registered_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val name: String = "",
    val surname: String = "",
    val mobile: Long = 0,
    @Column(unique = true)
    val email: String = "",
    val password: String = ""
)