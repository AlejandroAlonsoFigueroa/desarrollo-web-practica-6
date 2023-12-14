package alejandro.figueroa.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class FiltroImprimirAutenticacion implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String usuario = request.getParameter("username");
		String contra = request.getParameter("password");
		
		System.out.println("Nombre de usuario: "+usuario);
		
		
		Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
		
		if(autenticacion != null) {
			System.out.println(autenticacion.getCredentials());
			System.out.println(autenticacion.getDetails());
			System.out.println(autenticacion.getName());
			System.out.println(autenticacion.getPrincipal());
			System.out.println(autenticacion.getAuthorities());
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
