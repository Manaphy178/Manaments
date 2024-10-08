package servicios;

import java.util.List;

import modelo.Instrumento;

public interface ServicioInstrumento {

	void registrarInstrumento(Instrumento i);

	List<Instrumento> obtenerInstrumentos();

	void borrarInstrumento(int id);

	Instrumento obtenerInstrumentoPorId(int id);

	void actualizarInstrumento(Instrumento i);

}
