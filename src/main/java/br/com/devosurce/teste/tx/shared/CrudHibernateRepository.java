package br.com.devosurce.teste.tx.shared;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

/**
 * @author Guilherme Pacheco
 */
@SuppressWarnings("unchecked")
public abstract class CrudHibernateRepository<T, ID extends Serializable> extends
    HibernateRepository {

  private final String entityName;

  public CrudHibernateRepository(SessionFactory sessionFactory, String entityName) {
    super(sessionFactory);
    Validate.notBlank(entityName);
    this.entityName = entityName;
  }

  public Criteria criteria() {
    return session().createCriteria(entityName);
  }

  public String getEntityName() {
    return entityName;
  }

  public T findById(ID id) {
    return (T) session().byId(entityName).load(id);
  }

  public T save(T obj) {
    session().save(entityName, obj);
    return obj;
  }

  public <I extends Iterable<T>> I save(I iterable) {
    iterable.forEach(this::save);
    return iterable;
  }

  public T update(T obj) {
    session().update(entityName, obj);
    return obj;
  }

  public <I extends Iterable<T>> I update(I iterable) {
    iterable.forEach(this::update);
    return iterable;
  }

  public void delete(T obj) {
    session().delete(entityName, obj);
  }

  public void delete(Iterable<T> iterable) {
    iterable.forEach(this::delete);
  }

  public List<T> findAll() {
    return criteria().list();
  }

}
