package com.rahul.quora.clone.service

import com.rahul.quora.clone.data.Login
import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.dto.ApiResponse
import com.rahul.quora.clone.dto.UserDTO
import com.rahul.quora.clone.repository.UserRepository
import org.jetbrains.annotations.NotNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class RegisterUserService(val userRepository: UserRepository) : UserDetailsService {

//    @Autowired
//    private lateinit var userRepository: UserRepository

    fun registerUser(@NotNull userDTO: UserDTO): ApiResponse {
        val user = with(userDTO) {
            User(
                name = this.name,
                surname = surname,
                email = email,
                mobile = mobile,
                password = password
            )
        }
        val userEntity = userRepository.save(user)
        return ApiResponse().apply {
            data = userEntity
        }
    }

    fun isUserPresent(login: Login): Boolean {
        return userRepository.findByEmailAndPassword(login.email, login.password)?.run { true } ?: false
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = username?.let { userRepository.findByEmail(username) }

        return org.springframework.security.core.userdetails.User(username, user?.password, listOf())
    }

}