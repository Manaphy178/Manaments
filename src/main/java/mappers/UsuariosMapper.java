package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.*;

/**
 * Con spring jdbc tenemos que definir a parte como formar un objeto de Sombrero
 * cuando pidamos sombreros a la base de datos
 */

public class UsuariosMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("id"));
		u.setNombre(rs.getString("nombre"));
		u.setApellido(rs.getString("apellido"));
		u.setNomUsuario(rs.getString("nomUsuario"));
		u.setEmail(rs.getString("email"));
		u.setPass(rs.getString("pass"));
		u.setCodPostal(Long.parseLong(rs.getString("codPostal")));
		return u;
	}

}
