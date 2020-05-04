package hr.littlemouse.readingChallenge.config.security;

import hr.littlemouse.readingChallenge.config.security.jwt.JwtTokenVerifier;
import hr.littlemouse.readingChallenge.config.security.jwt.JwtUsernamePasswordFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static hr.littlemouse.readingChallenge.data.enumeration.UserRole.ADMIN;
import static hr.littlemouse.readingChallenge.data.enumeration.UserRole.USER;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernamePasswordFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(), JwtUsernamePasswordFilter.class)
                .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .antMatchers("/api/users/**").hasAnyRole(ADMIN.name(), USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
