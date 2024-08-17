package com.rahul.quora.clone.data

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "registered_user")
data class User(val name: String, val surname: String, val mobile: Long, val email: String)