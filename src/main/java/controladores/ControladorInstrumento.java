package controladores;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daos.InstrumentosDAO;
import modelo.Instrumento;

@Controller
@RequestMapping("admin/")
public class ControladorInstrumento {
	@Autowired
	private InstrumentosDAO instrumentosDAO;

	@RequestMapping("instrumentos")
	public String obtenerInstrumentos(Model model) {
		List<Instrumento> instrumentos = instrumentosDAO.obtenerInstrumentos();
		model.addAttribute("instrumentos", instrumentos);
		return "admin/instrumentos";
	}

	@RequestMapping("instrumentos-borrar")
	public String borrarInstrumento(String id, Model model) {
		instrumentosDAO.borrarInstrumento(Integer.parseInt(id));
		return obtenerInstrumentos(model);
	}

	@RequestMapping("instrumentos-nuevo")
	public String nuevoInstrumento(Model model) {
		Instrumento i = new Instrumento();
		i.setPrecio(1);
		model.addAttribute("nuevoInstrumento", i);
		return "admin/instrumentos-nuevo";

	}

	@RequestMapping("instrumentos-guardar-nuevo")
	public String guardarNuevoInstrumento(Instrumento nuevoInstrumento, Model model, HttpServletRequest request) {
		// lo suyo seria valiar el libro antes de nada
		instrumentosDAO.registrarInstrumento(nuevoInstrumento);

		// nuevoLibro ya tiene el archvo subido, simplemente
		// queremos guardar el archivo en una ruta concreta
		// el proyecto realmente se esta ejecutando en una ruta
		// distinta a la del workspace
		// necesitamos saber esa ruta:
		String rutaRealDelProyecto = request.getServletContext().getRealPath("");
		// vamos a crear una carpeta para las subidas de archivo:
		File rutaSubidas = new File(rutaRealDelProyecto + "/subidas");
		if (!rutaSubidas.exists()) {
			rutaSubidas.mkdirs();
		}
		String nombreArchivo = nuevoInstrumento.getId() + ".jpg";
		// guardar el archivo subido a la ruta indicada
		try {
			nuevoInstrumento.getFoto().transferTo(new File(rutaSubidas, nombreArchivo));
			System.out.println("portada del producto subida en: " + rutaRealDelProyecto + "subidas");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obtenerInstrumentos(model);
	}

	/*@RequestMapping("instrumentos-editar")
	public String editarInstrumento(Model model, int id) {

	}*/
}
