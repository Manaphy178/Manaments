package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuarios {

	void registrarUsuario(Usuario u);
	List<Usuario> obtenerUsuario();
}
