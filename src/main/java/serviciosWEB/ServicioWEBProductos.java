package serviciosWEB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import daos.InstrumentosDAO;
import modelo.Instrumento;

@Controller
public class ServicioWEBProductos {

	@Autowired
	private InstrumentosDAO instrumentosDAO;

	@RequestMapping("obtener-productos-json")
	public ResponseEntity<String> obtenerProductos() {
		List<Instrumento> instrumentos = instrumentosDAO.obtenerInstrumentos();
		String respuesta = new Gson().toJson(instrumentos);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
}
