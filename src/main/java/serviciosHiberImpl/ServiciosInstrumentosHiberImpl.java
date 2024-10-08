package serviciosHiberImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Instrumento;
import servicios.ServicioInstrumento;

@Service
@Transactional
public class ServiciosInstrumentosHiberImpl implements ServicioInstrumento {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarInstrumento(Instrumento i) {
		sessionFactory.getCurrentSession().save(i);
	}

	@Override
	public List<Instrumento> obtenerInstrumentos() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Instrumento.class);
		return c.list();

	}

	@Override
	public void actualizarInstrumento(Instrumento i) {
		sessionFactory.getCurrentSession().merge(i);
	}

	@Override
	public void borrarInstrumento(int id) {
		Instrumento i = (Instrumento) sessionFactory.getCurrentSession().get(Instrumento.class, id);
		sessionFactory.getCurrentSession().delete(i);
	}

	@Override
	public Instrumento obtenerInstrumentoPorId(int id) {
		return (Instrumento) sessionFactory.getCurrentSession().get(Instrumento.class, id);
	}

}
