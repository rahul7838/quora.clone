package com.rahul.quora.clone.controller

import com.rahul.quora.clone.data.Login
import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.service.RegisterUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
//@RestMapping
class UserSignUpController {

    @Autowired
    lateinit var registerUserService: RegisterUserService

    @PostMapping("/signup", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createNewUser(@RequestBody user: User): ResponseEntity<User> {
        println("create user api called")
        val userInstance = registerUserService.registerUser(user)
        return ResponseEntity.ok().body(userInstance)
    }

    @GetMapping("/login")
    fun userLogin(@RequestBody login: Login): ResponseEntity<Boolean> {
        val isPresent = registerUserService.isUserPresent(login)
        return ResponseEntity.ok(isPresent)
    }
}

