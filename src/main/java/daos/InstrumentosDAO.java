package daos;

import java.util.*;
import modelo.*;

public interface InstrumentosDAO {

	List<Instrumento> obtenerInstrumentos();

	void registrarInstrumento(Instrumento i);
	void borrarInstrumento(int id);
	void editarInstrumento(Instrumento i);
	Instrumento obtenerInstrumentoPorId(Long id);
	void actualizarInstrumento(Instrumento i);
}
