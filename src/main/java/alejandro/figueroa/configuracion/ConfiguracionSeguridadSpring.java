package alejandro.figueroa.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import alejandro.figueroa.filtros.FiltroImprimirAutenticacion;
import alejandro.figueroa.servicios.ObtencionDetalleUsuario;

@Configuration
@EnableWebSecurity(debug = true)
public class ConfiguracionSeguridadSpring extends WebSecurityConfigurerAdapter{
	@Autowired 
	private PasswordEncoder codificadorBcrypt;
	
	@Autowired
	private AuthenticationProvider proveedorAutenticacion;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*auth.inMemoryAuthentication()
		.withUser("ale")
		//.password(codificadorContras.encode("jej"))
		.password("{noop}miContra")
		.roles("admin");
		*/
		
		// Traerme los usuarios de la BBDD
		
		
		//auth.jdbcAuthentication().dataSource(this.fuenteDatos).passwordEncoder(codificadorBcrypt);
		
		/*auth.userDetailsService(new ObtencionDetalleUsuario())
		.passwordEncoder(codificadorBcrypt);
	
		System.out.println("Haciendo algo");*/
		
		auth.authenticationProvider(proveedorAutenticacion);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.addFilterAfter(new FiltroImprimirAutenticacion(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers("/holaMundoVista").authenticated()
		.antMatchers("/holaMundoCadena").authenticated()
		.antMatchers("/soloAdministradores").authenticated()
		.antMatchers("/inicio").authenticated()
		.antMatchers("/administradores").hasAuthority("ADMIN")
		.antMatchers("/usuarios").hasAuthority("USER")
		.antMatchers("/").authenticated()
		.and().formLogin()
		.and().httpBasic()
		.and().exceptionHandling().accessDeniedPage("/accesoDenegado");		
	}
	
	
	/*@Bean
	protected PasswordEncoder obtenerCodificadorContras() {
		//PasswordEncoder codificador = NoOpPasswordEncoder.getInstance();
		
		//return codificador;
		
		return new BCryptPasswordEncoder();
	}
	*/
	
	
}
