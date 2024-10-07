package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daos.UsuariosDAO;
import modelo.Usuario;

@Controller
@RequestMapping("admin/")
public class ControladorUsuario {
	@Autowired
	private UsuariosDAO usuariosDAO;
	@RequestMapping("usuarios")
	public String obtenerUsuarios(Model model) {
		List<Usuario> usuarios=usuariosDAO.obtenerUsuario();
		model.addAttribute("usuarios",usuarios);
		return "admin/usuarios";
	}
}
