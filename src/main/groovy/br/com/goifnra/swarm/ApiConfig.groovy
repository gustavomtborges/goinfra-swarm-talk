package br.com.goifnra.swarm

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class ApiConfig {

    @Bean
    CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource()
        CorsConfiguration config = new CorsConfiguration()
        config.setAllowCredentials(true)
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("OPTIONS")
        config.addAllowedMethod("GET")
        config.addAllowedMethod("POST")
        config.addAllowedMethod("PUT")
        config.addAllowedMethod("DELETE")
        source.registerCorsConfiguration("/**/*", config)
        return new CorsFilter(source)
    }

    /**
     * A servlet filter that inserts various values retrieved from the incoming http
     * request into the MDC
     *
     * @return {@link org.springframework.boot.web.servlet.FilterRegistrationBean}
     */
    @Bean
    FilterRegistrationBean userInsertingMdcFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean()
        MDCInsertingServletFilter userFilter = new MDCInsertingServletFilter()
        registrationBean.setFilter(userFilter)
        return registrationBean
    }
}
