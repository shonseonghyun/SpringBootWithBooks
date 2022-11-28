//package com.shson.book.springboot.config.auth;
//
//import com.shson.book.springboot.domain.user.Role;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//
//    }
//}
//@RequiredArgsConstructor
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig  {
////    private final CustomOauth
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable().headers().frameOptions().disable()
////                .and()
////                .authorizeRequests() //URL별 권한 설정 시작점
////                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //권한 관리 대상 지정 옵션
////                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //해당 url은 해당 권한이 있는 사람만
////                .anyRequest().authenticated() // 나머지 url들은 인증된 사용자들만
////                .and()
////                .logout().logoutSuccessUrl("/")
////                .and()
////                .oauth2Login()
////                .userInfoEndpoint()
////                .userService();
