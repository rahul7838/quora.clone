package com.rahul.quora.clone.database

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QuoraFlyway {

    @Bean
    fun getFlyway(): Flyway {
        val flyway = Flyway.configure()
        flyway
            .dataSource("jdbc:mysql://db:3306/quora-db", "root", "root")
            .baselineOnMigrate(true)
            .baselineDescription("added_flyway")
        return flyway.load()
    }
}