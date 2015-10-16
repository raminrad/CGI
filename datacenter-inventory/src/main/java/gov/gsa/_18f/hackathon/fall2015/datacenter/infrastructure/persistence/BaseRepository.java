package gov.gsa._18f.hackathon.fall2015.datacenter.infrastructure.persistence;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.LobHandler;

/**
 * @author dfladung
 * 
 */
public abstract class BaseRepository<T extends BaseEntity> {

	private Class<T> clazz;

	public BaseRepository(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Autowired
	protected SessionFactory datacenterSessionFactory;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	protected LobHandler lobHandler;

	@SuppressWarnings("unchecked")
	public T find(Long id) {
		return (T) datacenterSessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return datacenterSessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public Long save(T entity) {
		datacenterSessionFactory.getCurrentSession().save(entity); // save instead of saveOrUpdate: hibernate bug
																	// HHH-6776
		return entity.getId();
	}

	public void update(T entity) {
		datacenterSessionFactory.getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		datacenterSessionFactory.getCurrentSession().delete(entity);
	}
}
