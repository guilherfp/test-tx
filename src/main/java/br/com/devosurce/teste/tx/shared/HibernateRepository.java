package br.com.devosurce.teste.tx.shared;

import org.apache.commons.lang3.Validate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Guilherme Pacheco
 */
public class HibernateRepository {

  private final SessionFactory sessionFactory;

  public HibernateRepository(SessionFactory sessionFactory) {
    Validate.notNull(sessionFactory);
    this.sessionFactory = sessionFactory;
  }

  protected final Session session() {
    return sessionFactory.getCurrentSession();
  }

}
