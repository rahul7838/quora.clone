package com.rahul.quora.clone.repository

import com.rahul.quora.clone.data.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int> {

    fun findByEmailAndPassword(email: String, password: String): User?

}