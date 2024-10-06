package daosImpl;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantesSQL.ConstantesSQL;
import modelo.*;
import daos.InstrumentosDAO;
import mappers.InstrumentosMapper;

public class InstrumentosDAOImpl implements InstrumentosDAO {
	private DataSource ds;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public void setDs(DataSource ds) {
		this.ds = ds;
		System.out.println("Configurando simple insert");
		this.simpleInsert = new SimpleJdbcInsert(ds);
		this.simpleInsert.withTableName("tabla_instrumentos").usingGeneratedKeyColumns("id");
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public List<Instrumento> obtenerInstrumentos() {
		List<Instrumento> instrumentos = this.jdbcTemplate.query(ConstantesSQL.SQL_OBTENER_INSTRUMENTOS,
				new InstrumentosMapper());
		return instrumentos;
	}

	@Override
	public void registrarInstrumento(Instrumento i) {
		this.jdbcTemplate.update(ConstantesSQL.SQL_REGISTRAR_INSTRUMENTO, i.getNombre(), i.getTipo(), i.getMarca(),
				i.getGamma(), i.getDesc(), i.getPrecio());
	}

	@Override
	public void borrarInstrumento(int id) {
		this.jdbcTemplate.update(ConstantesSQL.SQL_BORRAR_INSTRUMENTOS, id);

	}

	@Override
	public void editarInstrumento(Instrumento i) {
		// TODO Auto-generated method stub

	}

	@Override
	public Instrumento obtenerInstrumentoPorId(Long id) {
		Instrumento i = this.jdbcTemplate.queryForObject(ConstantesSQL.SQL_OBTENER_INSTRUMENTO_POR_ID,
				new InstrumentosMapper(), id);
		return i;
	}

	@Override
	public void actualizarInstrumento(Instrumento i) {
		this.jdbcTemplate.update(ConstantesSQL.SQL_ACTUALIZAR_INSTRUMENTO, i.getNombre(), i.getTipo(), i.getMarca(),
				i.getGamma(), i.getDesc(), i.getPrecio(), i.getId());

	}

}
