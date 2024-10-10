package serviciosHiberImpl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
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
	public List<Usuario> obtenerUsuarios() {
		System.out.println("ServicioUsuarioHiberIMPL");
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		List<Usuario> us = c.list();
		return us;
	}

	@Override
	public Usuario obtenerUsuarioPorEmailPass(String email, String pass) {
		Usuario usuario = null;
		/*
		 * Con hibertante, criteria no es el unico mecanismo para comunicarse con la
		 * base de datos, otras formas comunes son:
		 */
//		hql:psudo-lenguaje de consultas similar a sql
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		c.add(Restrictions.eq("email", email));
		c.add(Restrictions.eq("pass", pass));
		if (c.uniqueResult() != null) {
			usuario = (Usuario) c.uniqueResult();
		}
		return usuario;
	}

}
