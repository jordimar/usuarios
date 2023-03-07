package com.inicio.scurity;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
 	@Bean
	public JdbcUserDetailsManager usersDetailsJdbc(DataSource dataSource) {
		JdbcUserDetailsManager jdbcDetails = new JdbcUserDetailsManager();
		jdbcDetails.setDataSource(dataSource);
		jdbcDetails.setUsersByUsernameQuery("select username, password, enabled" + " from users where username=?");
		jdbcDetails.setAuthoritiesByUsernameQuery("select username, authority " + "from authorities where username=?");
			
		return jdbcDetails;
	}


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()//.anyRequest().permitAll();
				.antMatchers("/**").authenticated().and().httpBasic();

		return http.build();
	}
	
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
