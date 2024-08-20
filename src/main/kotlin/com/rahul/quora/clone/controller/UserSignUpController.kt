package com.rahul.quora.clone.controller

import com.rahul.quora.clone.data.Login
import com.rahul.quora.clone.dto.ApiResponse
import com.rahul.quora.clone.dto.UserDTO
import com.rahul.quora.clone.service.RegisterUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
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
    fun createNewUser(@RequestBody user: UserDTO): ApiResponse {
        println("create user api called")
        return registerUserService.registerUser(user)
    }

    @GetMapping("/login")
    fun userLogin(@RequestBody login: Login): ResponseEntity<Boolean> {
        val isPresent = registerUserService.isUserPresent(login)
        return ResponseEntity.ok(isPresent)
    }
}

