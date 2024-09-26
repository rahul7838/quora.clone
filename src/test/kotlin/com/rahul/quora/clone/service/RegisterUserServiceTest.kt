package com.rahul.quora.clone.service

import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.dto.UserDTO
import com.rahul.quora.clone.repository.UserRepository
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals

class RegisterUserServiceTest {

    private val userRepository: UserRepository = mock()

    private val registerUserService: RegisterUserService = RegisterUserService(userRepository)

    @Test
    fun registerUserTest() {
        val userDTO  = UserDTO("rahul", "singhal", "rahul@singhal.io", 7987272882, "password")
        val user = with(userDTO) {
            User(
                name = name,
                surname = surname,
                email = email,
                mobile = mobile,
                password = password
            )
        }
        val expected: User = user.copy(id = 1)
        `when`(userRepository.save(user)).thenReturn(expected)
        val actual = registerUserService.registerUser(userDTO)
        assertEquals(actual.data as User, expected)
    }
}