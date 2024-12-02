package com.rahul.quora.clone.controller

import com.rahul.quora.clone.data.Login
import com.rahul.quora.clone.dto.ApiResponse
import com.rahul.quora.clone.dto.UserDTO
import com.rahul.quora.clone.service.RegisterUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
//@RequestMapping("/user")
class UserSignUpController {

    @Autowired
    lateinit var registerUserService: RegisterUserService


    @PostMapping(
        "/signup",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createNewUser(@RequestBody user: UserDTO): ResponseEntity<ApiResponse> {
        println("create user api called")
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(registerUserService.registerUser(user))
    }

    @GetMapping("/login")
    fun userLogin(): ResponseEntity<Boolean> {
        //use basic auth in postman and username-email and password
        val isAuthenticated = SecurityContextHolder.getContext().authentication.isAuthenticated
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(isAuthenticated)
    }
}

