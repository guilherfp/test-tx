package br.com.devosurce.teste.tx.user;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.devosurce.teste.tx.config.UserData;

/**
 * @author Guilherme Pacheco
 */
@Repository
public class UserRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public UserRepository(@UserData DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
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

}
