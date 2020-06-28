//package com.TLCN_BOOKING.SecurityConfig;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.TLCN_BOOKING.Services.userService;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebsecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Resource(name = "userService")
//	private userService userSv;
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userSv).passwordEncoder(passwordEncoder());
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/*.css");
//		web.ignoring().antMatchers("/*.js");
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//        .antMatchers("/register").permitAll()
//        .antMatchers("/").hasRole("customer")
//        .antMatchers("/admin").hasRole("admin")
//        .and()
//    .formLogin()
//        .loginPage("/login")
//        .usernameParameter("username")
//        .passwordParameter("password")
//        .defaultSuccessUrl("/")
//        .failureUrl("/login?error")
//        .and()
//    .exceptionHandling()
//        .accessDeniedPage("/403");
//	}
//	
//
//}