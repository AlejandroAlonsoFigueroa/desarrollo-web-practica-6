package alejandro.figueroa.dao;

import alejandro.figueroa.dto.Usuario;

public interface UserDAO {
	Usuario encontrarUsuarioPorNombreUsuario(String nombreUsuario);
}
