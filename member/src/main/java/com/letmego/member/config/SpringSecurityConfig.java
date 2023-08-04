package com.letmego.member.config;

import com.letmego.member.security.JwtAuthenticationFilter;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
@Slf4j
public class SpringSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("SecurityFilterChain is running........");
        http.csrf().disable().cors();
        http.authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(
                                "/",
                                "/auth/**"
                        ).permitAll()
//                        .requestMatchers("/view/setting/admin").hasRole("ADMIN")
//                        .requestMatchers("/view/setting/user").hasRole("USER")
                        .anyRequest().authenticated()
        );
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterAfter(
                jwtAuthenticationFilter,
                CorsFilter.class
        );
//        http.formLogin(login -> login
//                        .loginPage("http://localhost:5173/sign-in/")
////                        .loginProcessingUrl("/login-process")
////                        .usernameParameter("userid")
////                        .passwordParameter("pw")
//                        .defaultSuccessUrl("/view/dashboard", true)
//                        .permitAll()
//                )
//                .logout(withDefaults());

        return http.build();
    }
}
