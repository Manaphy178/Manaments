package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuarios {

	void registrarUsuario(Usuario u);

	List<Usuario> obtenerUsuarios();

	Usuario obtenerUsuarioPorEmailPass(String email, String pass);
}
