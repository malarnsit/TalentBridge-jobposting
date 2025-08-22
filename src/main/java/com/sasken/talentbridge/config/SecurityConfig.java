package com.sasken.talentbridge.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/jobs/new", "/jobs/edit/**", "/jobs/delete/**").hasRole("HR") 
                .requestMatchers("/jobs/**").hasAnyRole("HR", "EMPLOYEE") 
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/jobs", true) 
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() 
    {
        return new InMemoryUserDetailsManager(
            User.withUsername("hr")
                .password("{noop}hr123")
                .roles("HR")
                .build(),
            User.withUsername("emp")
                .password("{noop}emp123")
                .roles("EMPLOYEE")
                .build()
        );
    }
}
