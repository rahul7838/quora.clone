package com.rahul.quora.clone

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication
@EnableAutoConfiguration(exclude = [SecurityAutoConfiguration::class])
class Application



fun main(args: Array<String>) {
	val context = runApplication<Application>(*args)
//	val registerUserService = context.getBean(RegisterUserService::class.java)
//	registerUserService.registerUser(User("rahul", "singhal", 7987272882, "rahulsinghal0308@gmail.com"))
}
