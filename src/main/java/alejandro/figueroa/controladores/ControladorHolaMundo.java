package alejandro.figueroa.controladores;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorHolaMundo {

	@GetMapping(value = "/holaMundoVista")
	public String holaMundo(Principal p, Authentication auth) {
		
		System.out.println(p.getName());
		
		System.out.println(auth.getAuthorities());
		
		return "hola-mundo";
	}
	
	@ResponseBody
	@GetMapping(value = "/holaMundoCadena")
	public String holaMundoCadena() {
		return "hola-mundo";
	}
	
	@GetMapping(value = "/adiosMundo")
	public String adiosMundo() {
		return "hola-mundo";
	}
	
	@GetMapping(value = "/soloAdministradores")
	@ResponseBody
	public String mostrarAlgoAdministradores() {
		return "Solo lo podrán ver los administradores";
	}
	

	@GetMapping(value = "/accesoDenegado")
	public String mostrarAccesoDenegado() {
		return "acceso-denegado";
	}
	
}
