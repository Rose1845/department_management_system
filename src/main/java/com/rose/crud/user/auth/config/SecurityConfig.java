package com.rose.crud.user.auth.config;

import com.rose.crud.user.repository.UserRepository;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static com.rose.crud.user.role.Permissions.*;
import static com.rose.crud.user.role.Role.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final JWTAuthenticationFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/**","/api/v1/auth/**","/v3/**", "/swagger-ui/**","/api/v1/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);



        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
////        httpSecurity.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
//        httpSecurity.cors()
//                .and()
//                .csrf()
//                .disable()
//                .authorizeHttpRequests(
//                        (auth1) -> {
//                            auth1.requestMatchers("","api/v1/**","/api/v1/auth/login","/api/v1/auth/init", "/v3/**", "/swagger-ui/**")
//                                    .permitAll();
////                                    .requestMatchers(HttpMethod.POST,"/api/v1/auth/register").hasAnyRole(ADMIN.name(),MANAGER.name())
////                                    .requestMatchers(HttpMethod.POST,"/api/v1/auth/register","/api/v1/courses/**","/api/v1/departments/**","/api/v1/units/**","/api/v1/students/**","/api/v1/teachers/**").hasRole(ADMIN.name())
//////                                    .requestMatchers(HttpMethod.GET,"/api/v1/**").hasAnyRole(ADMIN.name(),MANAGER.name(),USER.name())
////                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/courses/**","/api/v1/departments/**","/api/v1/units/**","/api/v1/students/**","/api/v1/teachers/**").hasRole(ADMIN.name())
////                                    .requestMatchers(HttpMethod.PUT,"/api/v1/students","/api/v1/teachers").hasAnyRole(ADMIN.name(),MANAGER.name(),USER.name())
////                                    .requestMatchers(HttpMethod.PUT,"api/v1/courses","/api/v1/departments","/api/v1/units","/api/v1/students","/api/v1/teachers").hasRole(ADMIN.name());
//
////                                    .requestMatchers(HttpMethod.POST,"/api/v1/auth/register").hasAnyAuthority(ADMIN_CREATE.name(),MANAGER.name())
////                                    .requestMatchers(HttpMethod.POST,"/api/v1/auth/register","/api/v1/courses/**","/api/v1/departments/**","/api/v1/units/**","/api/v1/students/**","/api/v1/teachers/**").hasAuthority(ADMIN_CREATE.name())
//////                                    .requestMatchers(HttpMethod.GET,"/api/v1/**").hasAnyRole(ADMIN.name(),MANAGER.name(),USER.name())
////                                    .requestMatchers(HttpMethod.DELETE,"/api/v1/courses/**","/api/v1/departments/**","/api/v1/units/**","/api/v1/students/**","/api/v1/teachers/**").hasAuthority(ADMIN_DELETE.name())
////                                    .requestMatchers(HttpMethod.PUT,"/api/v1/students","/api/v1/teachers").hasAnyAuthority(ADMIN.name(), MANAGER_UPDATE.name(),USER.name())
////                                    .requestMatchers(HttpMethod.PUT,"api/v1/courses","/api/v1/departments","/api/v1/units","/api/v1/students","/api/v1/teachers").hasAuthority(ADMIN_UPDATE.name());
//
//
//
//                        }).authorizeHttpRequests(
//                        (auth2) -> {
//                            try {
//                                auth2
//                                        .anyRequest()
//                                        .authenticated()
//                                        .and()
//                                        .sessionManagement()
//                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                                        .and()
//                                        .authenticationProvider(authenticationProvider)
//                                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//                            } catch (Exception e) {
//
//                                throw new RuntimeException(e);
//
//                            }
//
//                        });
//        return httpSecurity.build();
//    }



    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowCredentials(false);
        corsConfiguration.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
        source.registerCorsConfiguration("/**", corsConfiguration);
        source.registerCorsConfiguration("/api/v1/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
