package br.com.devosurce.teste.tx.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

/**
 * @author Guilherme Pacheco
 */
@Repository
public class UserRepository {

  private JPAQuery<User> jpaQuery;

  public UserRepository() {
    jpaQuery = new JPAQuery<>();
  }

  public User findById(long id) {
    return null;
  }

  public void save(User user) {

  }

  public void update(User user) {

  }

  public void delete(User user) {

  }

  public List<User> findAll() {
    return null;
  }

  public List<User> find() {
    return null;
  }

}
