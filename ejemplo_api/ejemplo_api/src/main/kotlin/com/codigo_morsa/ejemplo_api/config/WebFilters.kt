import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.cors.reactive.CorsWebFilter

@Configuration
class WebFilters {

    @Bean
    fun corsWebFilter(): CorsWebFilter {
        // Crear una nueva configuración CORS
        val corsConfig = CorsConfiguration()

        // Especificar los orígenes permitidos
        corsConfig.allowedOrigins = listOf("http://localhost:3000")

        // Especificar el tiempo máximo que se permite cachear la respuesta preflight
        corsConfig.maxAge = 8000L

        // Especificar los métodos HTTP permitidos
        corsConfig.addAllowedMethod("GET")
        corsConfig.addAllowedMethod("POST")
        corsConfig.addAllowedMethod("OPTIONS")

        // Crear una fuente de configuración CORS basada en la URL
        val source = UrlBasedCorsConfigurationSource()

        // Registrar la configuración CORS para todas las rutas
        source.registerCorsConfiguration("/**", corsConfig)

        // Retornar un nuevo filtro CORS con la fuente de configuración
        return CorsWebFilter(source)
    }
}
