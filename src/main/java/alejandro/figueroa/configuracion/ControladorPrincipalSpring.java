package alejandro.figueroa.configuracion;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ControladorPrincipalSpring extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] clasesConfiguracion = {ConfiguracionSpring.class};
		return clasesConfiguracion;
	}

	@Override
	protected String[] getServletMappings() {
		String[] rutasManejadasSpring = {"/"};
		return rutasManejadasSpring;
	}

}
