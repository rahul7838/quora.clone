package com.rahul.quora.clone.security

import org.springframework.aot.generate.ValueCodeGenerator.withDefaults
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter

@Configuration
@EnableWebSecurity
class WebSecurity : DefaultWebSecurityExpressionHandler() {

    @Bean
    open fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
            .authorizeHttpRequests {
                it
                    .anyRequest()
                    .authenticated()
            }
//            .oauth2Login(Customizer.withDefaults())
            //Configure spring security header to include xss protection header & CSP header in response
            .headers { headersConfigurer ->
                headersConfigurer.xssProtection { it.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK) }
                    .contentSecurityPolicy { it.policyDirectives("default-src 'self'; script-src 'self'; style-src 'self'; img-src 'self' data:;") }
            }
            .httpBasic {

            }
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}