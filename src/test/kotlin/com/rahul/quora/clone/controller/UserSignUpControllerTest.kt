package com.rahul.quora.clone.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.service.RegisterUserService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.nio.charset.StandardCharsets

@WebMvcTest(UserSignUpController::class, excludeAutoConfiguration = [SecurityAutoConfiguration::class])
class UserSignUpControllerTest {

    @MockBean
    private lateinit var registerUserService: RegisterUserService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun createUserTest() {
        val user = User(
            name = "rahul",
            surname = "singhal",
            mobile = 7987272882,
            email = "rahul@singhal.io"
        )
        val expected = user.copy(id = 1)
        val objectMapper = ObjectMapper().writer()
        val expectedJsonObject = objectMapper.writeValueAsString(expected)
//        `when`(registerUserService.registerUser(user)).thenReturn(expected)
        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(objectMapper.writeValueAsString(user))
        )
            .andExpect(status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(MockMvcResultMatchers.content().json(expectedJsonObject))
            .andReturn()
        verify(registerUserService, times(1)).registerUser(user)
            //TODO test does not end why?
    }
}