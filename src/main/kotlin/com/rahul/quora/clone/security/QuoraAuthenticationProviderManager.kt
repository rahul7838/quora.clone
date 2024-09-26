package com.rahul.quora.clone.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager

@Configuration
class QuoraAuthenticationProviderManager {

    @Autowired
    private lateinit var quoraAuthenticationProvider: QuoraAuthenticationProvider

    @Bean
    fun authenticationProvider(): AuthenticationManager {
        return ProviderManager(quoraAuthenticationProvider)
    }
}