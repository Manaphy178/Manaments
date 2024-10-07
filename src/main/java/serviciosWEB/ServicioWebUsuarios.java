package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import daos.UsuariosDAO;
import modelo.Usuario;

@Controller
public class ServicioWebUsuarios {

	@Autowired
	private UsuariosDAO usuariosDAO;

	@RequestMapping("registrar-usuario-cliente")
	public ResponseEntity<String> registrarUsuario(String nombre, String apellido, String nomUsuario, String pass,
			String email, long codPostal) {
		Usuario u = new Usuario(nombre, apellido, nomUsuario, email, pass, codPostal);
//		Lo suyo seria validar antes de registrar
		usuariosDAO.registrarUsuario(u);
		return new ResponseEntity<String>("usuario registrado correctamente", HttpStatus.OK);

	}
}
