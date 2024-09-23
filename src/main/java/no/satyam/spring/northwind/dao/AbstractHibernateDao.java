package no.satyam.spring.northwind.dao;

import org.assertj.core.util.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
public abstract class AbstractHibernateDao<T extends Persistable> {

	private Class<T> clazz;

	@Autowired
	protected SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = Objects.requireNonNull(clazzToSet);
	}

	public T findOne(final long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public List findAll() {
		return (List) getCurrentSession().createQuery("from " + clazz.getName(), clazz);
	}

	public T create(final T entity) {
		getCurrentSession().persist(entity);
		return entity;
	}

	public T update(final T entity) {
		Objects.requireNonNull(entity);
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(final T entity) {
		Objects.requireNonNull(entity);
		getCurrentSession().remove(entity);
	}

	public void deleteById(final long entityId) {
		final T entity = findOne(entityId);
		Preconditions.checkState(entity != null, "The instance of class " + clazz.getName() + " is null!");
		delete(entity);
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}