package alejandro.figueroa.dao;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import alejandro.figueroa.dto.Usuario;

@Repository
public class UserDAOImpl implements UserDAO{

	/*@Autowired
	private DataSource fuenteDatos;
	
	
	private JdbcTemplate plantillaJdbc = new JdbcTemplate(fuenteDatos);*/
	
	@Override
	public Usuario encontrarUsuarioPorNombreUsuario(String nombreUsuario) {
		/*String consultaUsuarios = "select * from users where username = ?";
		
		Object[] argumentos = {nombreUsuario};
		Usuario u = plantillaJdbc.queryForObject(consultaUsuarios, argumentos, new BeanPropertyRowMapper<Usuario>(Usuario.class));
		
		
		System.out.println(u);
		*/
		return new Usuario("alejandro", "miContra", 44);
	}

}
