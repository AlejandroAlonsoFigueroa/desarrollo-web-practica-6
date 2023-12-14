package alejandro.figueroa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ControladorParametros {

	@GetMapping(value = "/saludos/{nombrePersona}")
	public String escribirSaludo(@PathVariable(name = "nombrePersona") String pNombre) {
		return "Hola, te mando un saludo "+pNombre;
	}
}
