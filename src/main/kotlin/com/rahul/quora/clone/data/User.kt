package com.rahul.quora.clone.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "registered_user")
data class User(

    @Id
    @GeneratedValue
    val id: Long = 0,
    val name: String,
    val surname: String,
    val mobile: Long,
    val email: String
)