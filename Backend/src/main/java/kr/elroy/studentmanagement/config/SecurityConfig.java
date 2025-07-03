package kr.elroy.studentmanagement.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests

                                .requestMatchers("/swagger-ui/**",
                                        "/v3/api-docs/**",
                                        "/swagger-resources/**",
                                        "/webjars/**").permitAll()

                                // /actuator/health와 같은 관리 엔드포인트는 인증 없이 접근 허용
                                .requestMatchers(HttpMethod.GET, "/actuator/health", "/actuator/info")
                                .permitAll()

                                // GET 요청 허용
                                .requestMatchers(HttpMethod.GET,
                                        "/v1/users/**")
                                .permitAll()

                                // POST 요청 허용
                                .requestMatchers(HttpMethod.POST,
                                        "/v1/users/**")
                                .permitAll()

                                // PATCH 요청 허용
                                .requestMatchers(HttpMethod.PATCH,
                                        "/v1/users/**")
                                .permitAll()

                                // 그 외의 요청은 인증 필요
                                .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable); // CSRF 비활성화

        return http.build();
    }
}
