package alejandro.figueroa.servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import  org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import alejandro.figueroa.dao.UserDAO;
import alejandro.figueroa.dao.UserDAOImpl;
import alejandro.figueroa.dto.Usuario;

@Service
public class ObtencionDetalleUsuario implements UserDetailsService{

	private UserDAO daoUsuarios = new UserDAOImpl();
	
	
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException{
		
		Usuario us = daoUsuarios.encontrarUsuarioPorNombreUsuario(nombreUsuario);
		
		if(us == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		System.out.println(us);
		
		List<SimpleGrantedAuthority> autoridades = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");
		
		autoridades.add(admin);
		
		return new User("alejandro", "$2a$10$o5EXVJx/Yd/NJnAbDWp0tun30KqH00FOKK.ptNkpJpBPKx.xwSF8i", autoridades);
	}
	
	public ObtencionDetalleUsuario(){
		
	}
}
