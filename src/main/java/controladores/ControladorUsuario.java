package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;
import servicios.ServicioUsuarios;

@Controller
@RequestMapping("admin/")
public class ControladorUsuario {
	@Autowired
	private ServicioUsuarios servicioUsuarios;

	@RequestMapping("usuarios")
	public String obtenerUsuarios(Model model) {
		List<Usuario> usuarios = servicioUsuarios.obtenerUsuario();
		model.addAttribute("usuarios", usuarios);
		return "admin/usuarios";
	}
}
