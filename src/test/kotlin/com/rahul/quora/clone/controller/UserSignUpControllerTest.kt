package com.rahul.quora.clone.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.dto.ApiResponse
import com.rahul.quora.clone.dto.UserDTO
import com.rahul.quora.clone.service.RegisterUserService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.nio.charset.StandardCharsets

@WebMvcTest(UserSignUpController::class, excludeAutoConfiguration = [SecurityAutoConfiguration::class])
class UserSignUpControllerTest {

    @MockBean
    lateinit var registerUserService: RegisterUserService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun createUserTest() {
        val userDto = UserDTO(
            name = "rahul",
            surname = "singhal",
            mobile = 7987272882,
            email = "rahul@singhal.io",
            password = "password"
        )
        val user = with(userDto) {
            User(
                name = name,
                surname = surname,
                email = email,
                mobile = mobile,
                password = password
            )
        }

        val apiResponse = ApiResponse().apply {
            data = user
        }
        val objectMapper = ObjectMapper().writer()
        val expectedJsonObject = objectMapper.writeValueAsString(apiResponse)
        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(objectMapper.writeValueAsString(userDto))
        )
            .andExpect(status().`is`(HttpStatus.CREATED.value()))
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().json(expectedJsonObject))
            .andReturn()
        verify(registerUserService, times(1)).registerUser(any())
            //TODO test does not end why?
    }
}