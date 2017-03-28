package com.example.config;

import com.example.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;


/**
 * Created by zach on 2/7/2017.
 */
//controls the security and where users can go with certain credentials
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String SALT = "slklddkdkdlsl12323ll2l2dldl";
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/*",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/console/**",
            "/registration",
            "/resources/static/**",
            "/resources/static/js",
            "/resources/static/css"



    };
    @Autowired
    private Environment env;
    @Autowired
    private UserSecurityService userSecurityService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* List<String> activeProfiles = Arrays.asList(env.getActiveProfiles()); //returns all active profiles in enviroment
        if(activeProfiles.contains("dev"))//if dev label, disable these restrictions
        {
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }*/

        http                                     //setting all url properties I believe\
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/tests")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder()); //checks user
    }
}
