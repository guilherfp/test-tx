package br.com.devosurce.teste.tx.user;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.devosurce.teste.tx.shared.CrudHibernateRepository;

/**
 * @author Guilherme Pacheco
 */
@UserTx
@Repository
public class UserRepository extends CrudHibernateRepository<User, Long> {

  @Autowired
  public UserRepository(SessionFactory sessionFactory) {
    super(sessionFactory, "User");
  }

}
