package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.*;

/**
 * Con spring jdbc tenemos que definir a parte como formar un objeto de Sombrero
 * cuando pidamos sombreros a la base de datos
 */

public class InstrumentosMapper implements RowMapper<Instrumento> {

	@Override
	public Instrumento mapRow(ResultSet rs, int arg1) throws SQLException {
		Instrumento i = new Instrumento();
		i.setId(rs.getInt("id"));
		i.setNombre(rs.getString("nombre"));
		i.setTipo(rs.getString("tipo"));
		i.setMarca(rs.getString("marca"));
		i.setGamma(rs.getString("gamma"));
		i.setDesc(rs.getString("description"));
		i.setPrecio(rs.getDouble("precio"));
		return i;
	}

}
