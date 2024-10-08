package serviciosHiberImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Usuario;
import servicios.ServicioUsuarios;

@Service
@Transactional
public class ServicioUsuariosHiberImpl implements ServicioUsuarios {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarUsuario(Usuario u) {
		sessionFactory.getCurrentSession().save(u);
	}

	@Override
	public List<Usuario> obtenerUsuario() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		return c.list();
	}

}
