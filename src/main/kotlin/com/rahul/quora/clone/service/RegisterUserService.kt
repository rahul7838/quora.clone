package com.rahul.quora.clone.service

import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegisterUserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun registerUser(user: User) = userRepository.save(user)

}