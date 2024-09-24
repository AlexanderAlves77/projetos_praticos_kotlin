package tssti.fullstack.backend_kotlin_rest_api.doc

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean


/*
 * Swagger Documentation da API
 */
class SwaggerConfig {
    @Bean
    fun customOpenAPI() : OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Rest API - Full Stacks")
                    .version("1.0")
                    .version("www.fulldevstacks.com.br")
                    .description("API REST Spring Boot Kotlin")
            )
    }
}