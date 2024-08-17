package com.rahul.quora.clone.repository

import com.rahul.quora.clone.data.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveCrudRepository<User, Int> {

}