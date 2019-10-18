package es.kairosds.blogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/articulos/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/articulos/").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/articulos/{id}/").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/articulos/{id}/**").permitAll();
		http.authorizeRequests().antMatchers("/articulos/{id}/comentario").permitAll();
		http.authorizeRequests().antMatchers("/articulos/{id}/comentario/").permitAll();

	}
}
