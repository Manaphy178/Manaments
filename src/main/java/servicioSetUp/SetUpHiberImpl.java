package servicioSetUp;

import java.sql.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Instrumento;
import modelo.Usuario;

@Service
@Transactional
public class SetUpHiberImpl implements SetUp {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void setUp() {
		/*
		 * vamos a usar una entidad par ver si ya hemos inicializado la base de datos
		 * dicha entidad la llamamos SetUp
		 */
		Criteria c = sessionFactory.getCurrentSession().createCriteria(modelo.SetUp.class);
		if (c.list().size() == 0) {
			/*
			 * la idea es que si no hay ningun registro en la tabla de setup pues preparemos
			 * los registros para todo el sistema
			 */
			Instrumento i1 = new Instrumento("Bajo", "bajo", "marca", "gamma", "description", 1,
					new Date(System.currentTimeMillis()));
			Instrumento i2 = new Instrumento("guitarra", "guitarra", "marca", "gamma", "description", 2,
					new Date(System.currentTimeMillis()));
			Instrumento i3 = new Instrumento("bateria", "bateria", "marca", "gamma", "description", 3,
					new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(i1);
			sessionFactory.getCurrentSession().save(i2);
			sessionFactory.getCurrentSession().save(i3);
			Usuario u1 = new Usuario("Javier", "Gonzalez", "mana", "jgonzalez@centronelson.org", "123", 28440);
			Usuario u2 = new Usuario("Sergio", "Prados", "prapra", "sprados@centronelson.org", "123", 28440);
			sessionFactory.getCurrentSession().save(u1);
			sessionFactory.getCurrentSession().save(u2);

			System.out.println("registros iniciales realizados correctamente");

			modelo.SetUp setUp = new modelo.SetUp();
			setUp.setCompleto(true);
			sessionFactory.getCurrentSession().save(setUp);
		}
	}

}
