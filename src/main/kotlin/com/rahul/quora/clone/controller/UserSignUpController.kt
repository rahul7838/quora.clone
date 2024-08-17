package com.rahul.quora.clone.controller

import com.rahul.quora.clone.data.User
import com.rahul.quora.clone.service.RegisterUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController()
class UserSignUpController {

    @Autowired
    lateinit var registerUserService: RegisterUserService

    @PostMapping("/signup", consumes = ["application/json"])
    fun createNewUser(@RequestBody user: User): ResponseEntity<User> {
        println("create user api called")
        val userInstance = registerUserService.registerUser(user)
        return ResponseEntity.ok().body(userInstance)
    }
}

