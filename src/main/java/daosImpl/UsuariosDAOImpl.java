package daosImpl;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import daos.UsuariosDAO;
import modelo.Usuario;

public class UsuariosDAOImpl implements UsuariosDAO {

	private DataSource ds;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public void setDs(DataSource ds) {
		this.ds = ds;
		System.out.println("Configurando simple insert");
		this.simpleInsert = new SimpleJdbcInsert(ds);
		this.simpleInsert.withTableName("tabla_usuarios");
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public void registrarUsuario(Usuario u) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
//		hay que indicar el nombre de la columna en base de datos
//		y el valor correspondiente a insertar
		valores.put("nombre", u.getNombre());
		valores.put("apellido", u.getApellido());
		valores.put("nomUsuario", u.getNomUsuario());
		valores.put("email", u.getEmail());
		valores.put("pass", u.getPass());
		valores.put("codPostal", u.getCodPostal());
		this.simpleInsert.execute(valores);

	}

}
