package com.tecniscan.interes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication

@EnableJpaRepositories("com.tecniscan.interes.database")

@EntityScan("com.tecniscan.interes.database.model")
class InteresApplication

fun main(args: Array<String>) {
	runApplication<InteresApplication>(*args)

}


@Bean
fun corsConfigurer(): WebMvcConfigurer {
	return object : WebMvcConfigurer {
		override fun addCorsMappings(registry: CorsRegistry) {
			registry.addMapping("/calcular-interes").allowedOrigins("http://localhost:8080")
		}
	}
}
