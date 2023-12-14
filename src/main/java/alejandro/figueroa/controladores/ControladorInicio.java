package alejandro.figueroa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {

	@GetMapping(value = "/inicio")
	public String retornarVistaInicio() {
		return "vista-inicio";
	}
	
	@GetMapping(value = "/usuarios")
	public String retornarVistaUsuarios() {
		return "vista-usuarios";
	}
	
	
	@GetMapping(value = "/administradores")
	public String retornarVistaAdministradores() {
		return "vista-administradores";
	}
	
	
}
