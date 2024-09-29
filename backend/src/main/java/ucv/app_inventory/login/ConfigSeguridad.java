package ucv.app_inventory.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; // Asegúrate de importar esta anotación
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Añade esta anotación
@EnableWebSecurity
public class ConfigSeguridad {

    // Definir AuthenticationManager como un bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Configuración de la cadena de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/v1/auth/login").permitAll() // Permitir el acceso al login sin autenticación
                    .anyRequest().authenticated() // Requerir autenticación para cualquier otra solicitud
                );
        return http.build();
    }

    // Definir un PasswordEncoder (BCrypt en este caso)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
