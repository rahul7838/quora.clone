package com.rahul.quora.clone.service

import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.repository.UserRepository
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class RegisterUserServiceTest {

    private val userRepository: UserRepository = mock()

    private val registerUserService: RegisterUserService = RegisterUserService(userRepository)

    @Test
    fun registerUserTest() {
        val user = User(
            name = "rahul",
            surname = "singhal",
            mobile = 7987272882,
            email = "rahul@singhal.io"
        )
        val expected = user.copy(id = 1)
        `when`(userRepository.save(user)).thenReturn(expected)
        val actual = registerUserService.registerUser(user)
        assertEquals(actual, expected)
    }
}