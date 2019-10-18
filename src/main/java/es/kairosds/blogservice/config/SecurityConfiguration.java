package es.kairosds.blogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		//Pages with required authentication 
				authorizeRequests().antMatchers(HttpMethod.POST, "/articulos/").authenticated().and().
		//Pages without any authentication required		
				authorizeRequests().antMatchers("/articulos/**").permitAll().and().
        csrf().disable();
	}
}
