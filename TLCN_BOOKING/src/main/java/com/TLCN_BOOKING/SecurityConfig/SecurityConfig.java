package com.TLCN_BOOKING.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.TLCN_BOOKING.Services.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
	 * withUser("sonha").password(
	 * "$2a$10$yO2CPlrPewUR0Lw0G6D6sOHU6Xy0EamOMg.nlzxGUiPfS2OgBducu").roles("ADMIN"
	 * ); auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).
	 * withUser("sonha1111").password(
	 * "$2a$10$yO2CPlrPewUR0Lw0G6D6sOHU6Xy0EamOMg.nlzxGUiPfS2OgBducu").roles("USER")
	 * ; //
	 * auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance
	 * ()).withUser("sena").password("123456").roles("USER"); }
	 */

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Chỉ cho phép user có quyền ADMIN truy cập đường dẫn /admin/**
		http.authorizeRequests().antMatchers("/AdminView/**").access("hasRole('ROLE_admin')");
		// Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn /user/**
		http.authorizeRequests().antMatchers("/CustomerView/**")
				.access("hasRole('ROLE_admin') or hasRole('ROLE_customer')");
		// Khi người dùng đã login, với vai trò USER, Nhưng truy cập vào trang yêu cầu
		// vai trò ADMIN, sẽ chuyển hướng tới trang /403
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/login");
		// Cấu hình cho Login Form.
		http.authorizeRequests().antMatchers("/register").permitAll().antMatchers("/").hasRole("customer")
				.antMatchers("/admin").hasRole("admin").and()
				.formLogin()//
				.loginProcessingUrl("/logining")//
				.loginPage("/login")//
//				.defaultSuccessUrl("/CustomerView/Home")//
				.usernameParameter("username")//
				.passwordParameter("password")
				.defaultSuccessUrl("/HomePage1")
				.failureUrl("/login?message=error")//
				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
	}
}
