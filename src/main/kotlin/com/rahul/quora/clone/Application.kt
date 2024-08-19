package com.rahul.quora.clone

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication
@EnableAutoConfiguration(exclude = [SecurityAutoConfiguration::class])
class Application



fun main(args: Array<String>) {
	val context = runApplication<Application>(*args)
	val flyway = context.getBean(Flyway::class.java)
	flyway.migrate()
}
