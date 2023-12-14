package alejandro.figueroa.configuracion;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import  org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvc
@ComponentScan("alejandro.figueroa")
public class ConfiguracionSpring {

	@Bean
	InternalResourceViewResolver resolverVistas(){
		InternalResourceViewResolver resolvedorVistas = new InternalResourceViewResolver();
		
		resolvedorVistas.setPrefix("/WEB-INF/vistas/");
		resolvedorVistas.setSuffix(".jsp");
		return resolvedorVistas;
	}
	
	@Bean("fuenteDatos")
	DataSource obtenerFuenteDatos() {
		String url = "jdbc:mysql://localhost:3306/seguridad_spring";
		String usuario = "root";
		String contra = "Nala10demayo";
		
		DriverManagerDataSource fuenteDatos =  new DriverManagerDataSource(url, usuario, contra);
		
		fuenteDatos.setDriverClassName(" com.mysql.cj.jdbc.Driver");
		return fuenteDatos;
	}
	
	@Bean
	PasswordEncoder obtenerCodificador() {
		return new BCryptPasswordEncoder();
	}
	
	
	//@Bean
	//@DependsOn({"fuenteDatos"})
	//JdbcTemplate obtenerPlantillaJdbc() {
	//	return new JdbcTemplate(obtenerFuenteDatos());
	//}
}
