package com.example.bosch_order_management_task.configuration;

import com.example.bosch_order_management_task.Collection.Address;
import com.example.bosch_order_management_task.Collection.User;
import com.example.bosch_order_management_task.enums.Role;
import com.example.bosch_order_management_task.repository.UserRepo;
import com.example.bosch_order_management_task.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/user/**").permitAll().antMatchers("/order/add").hasAuthority("BUYER");
        http.authorizeRequests().antMatchers("/product/add", "/product/addStock/**","/product/myProduct").hasAuthority("SELLER");
        http.authorizeRequests().antMatchers("/status/change/**").hasAuthority("BUYER");
        http.authorizeRequests().anyRequest().authenticated();
        http.headers().frameOptions().disable();
        http.httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @PostConstruct
    public void addAdmin() {

        if (userRepository.count() == 0) {
            User admin = new User("admin", "admin@gmail.com", "alpha", new Address("100/A", "bengaluru", "karnataka"), Role.ADMIN);
            userRepository.save(admin);
        }


    }
}
