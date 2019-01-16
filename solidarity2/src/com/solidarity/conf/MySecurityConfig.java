package com.solidarity.conf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.solidarity.conf.securitycomps.MyFailureHandler;
import com.solidarity.conf.securitycomps.MyLogoutHandler;
import com.solidarity.conf.securitycomps.MyLogoutSuccessHandler;
import com.solidarity.conf.securitycomps.MySavedRequestAwareAuthenticationSuccessHandler;
import com.solidarity.conf.securitycomps.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


	private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler = new MySavedRequestAwareAuthenticationSuccessHandler();

	private SimpleUrlAuthenticationFailureHandler myFailureHandler = new MyFailureHandler();

	@Autowired
	private AuthenticationEntryPoint restAuthenticationEntryPoint;


	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        // This assumes passwords are in plain text (but I hope they aren't!)
        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return authProvider;
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(restAuthenticationEntryPoint)
			.and()
			.authorizeRequests()
			.antMatchers("/").authenticated()
			.and().formLogin()
			.successHandler(mySuccessHandler)
			.failureHandler(myFailureHandler)
			.and()
			.logout().addLogoutHandler(new MyLogoutHandler())
			.logoutSuccessHandler(new MyLogoutSuccessHandler());

	}

}
