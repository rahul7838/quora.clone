package com.rahul.quora.clone

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler

@Configuration
@EnableWebSecurity
class WebSecurity : DefaultWebSecurityExpressionHandler() {

    @Bean
    open fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
            .authorizeHttpRequests {
                it
                    .anyRequest()
                    .permitAll()

            }
            .csrf().disable()
            .build()
    }

}