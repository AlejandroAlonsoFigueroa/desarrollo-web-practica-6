package alejandro.figueroa.dto;

public class Usuario{
	private String nombreUsuario;
	private String contra;
	private Integer id;
	public Usuario() {
		
	}
	

	public Usuario(String nombreUsuario, String contra, Integer id) {
		this.nombreUsuario = nombreUsuario;
		this.contra = contra;
		this.id = id;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contra=" + contra + ", id=" + id + "]";
	}
	
	
}
