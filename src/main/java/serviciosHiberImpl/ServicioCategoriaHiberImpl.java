package serviciosHiberImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Categoria;
import servicios.ServicioCategoria;

@Service
@Transactional
public class ServicioCategoriaHiberImpl implements ServicioCategoria {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Categoria> obtenerCategorias() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Categoria.class);
		return c.list();
	}

}
