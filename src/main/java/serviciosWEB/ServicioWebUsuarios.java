package serviciosWEB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import modelo.Usuario;
import servicios.ServicioUsuarios;

@Controller
public class ServicioWebUsuarios {

	@Autowired
	private ServicioUsuarios serviciosUsuarios;

	@RequestMapping("registrar-usuario-cliente")
	public ResponseEntity<String> registrarUsuario(String nombre, String apellido, String nomUsuario, String pass,
			String email, long codPostal) {
		Usuario u = new Usuario(nombre, apellido, nomUsuario, email, pass, codPostal);
//		Lo suyo seria validar antes de registrar
		serviciosUsuarios.registrarUsuario(u);
		return new ResponseEntity<String>("usuario registrado correctamente", HttpStatus.OK);

	}

	@RequestMapping("obtener-usuarios-json")
	public ResponseEntity<String> obtenerClientes() {
		List<Usuario> usuarios = serviciosUsuarios.obtenerUsuario();
		String respuesta = new Gson().toJson(usuarios);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
}
