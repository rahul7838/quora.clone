package com.rahul.quora.clone.dto

import jakarta.persistence.Column
import jakarta.persistence.UniqueConstraint

/**
    Not using [com.rahul.quora.clone.data.User] because all field are mandatory
 */
data class UserDTO(
    val name: String,
    val surname: String,
    val email: String,
    val mobile: Long,
    val password: String
)