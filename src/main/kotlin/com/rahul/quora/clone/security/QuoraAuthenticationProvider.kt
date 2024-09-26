package com.rahul.quora.clone.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class QuoraAuthenticationProvider : AuthenticationProvider {

    @Autowired
    private lateinit var userDetailsService: UserDetailsService


    override fun authenticate(authentication: Authentication?): Authentication {
        val user = userDetailsService.loadUserByUsername(authentication?.name)
        return UsernamePasswordAuthenticationToken(user.password, user.username)
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return true
    }
}