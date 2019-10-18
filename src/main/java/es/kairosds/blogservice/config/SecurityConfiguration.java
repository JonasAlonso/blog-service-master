package es.kairosds.blogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/articulos/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/articulos/**").permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.POST,"/articulos/").permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/articulos/").permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/articulos/{id}/").permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.POST,"/articulos/{id}/").permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.POST,"/articulos/{id}/comentario").permitAll();
//		http.authorizeRequests().antMatchers(HttpMethod.POST,"/articulos/{id}/comentario/").permitAll();

	}
	
	@Override
	public void configure(WebSecurity webSecurity) throws Exception
	{
	    webSecurity
	        .ignoring()
	            // All of Spring Security will ignore the requests
	            .antMatchers("/articulos/**"); // APIs use a key
	}
}
