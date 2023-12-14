package alejandro.figueroa.authProvider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import alejandro.figueroa.dao.UserDAOImpl;
import alejandro.figueroa.dto.Usuario;

@Component
public class CustomFormAuthenticationProvider implements AuthenticationProvider{

	@Autowired 
	private UserDAOImpl daoUsuarios;
	
	@Autowired
	private PasswordEncoder codificadorContra;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String nombreUsuario = authentication.getName();
		String contraEnPlano = authentication.getCredentials().toString();
		
		Usuario u = daoUsuarios.encontrarUsuarioPorNombreUsuario(nombreUsuario);
		
		if(u != null) {
			
			u.setContra("$2a$10$dZU0jiG2B9H0Mk0zm4.YluXXotd4PTF/BtD2A/pxRxfzxrxdNCSa2");
			if(codificadorContra.matches(contraEnPlano, u.getContra())) 
			{
				// Principal == nombreUsuario, credenciales == contraseña, authotities == roles
				List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
				
				roles.add(new SimpleGrantedAuthority("ADMIN"));
				
				return new UsernamePasswordAuthenticationToken(nombreUsuario, u.getContra(), roles);
			}
			else 
			{
				throw new BadCredentialsException("Contraseña incorrecta");
			}
		}else {
			throw new BadCredentialsException("El usuario "+nombreUsuario+"no existe.");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
