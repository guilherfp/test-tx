package br.com.devosurce.teste.tx.service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.devosurce.teste.tx.config.ServiceData;

/**
 * @author Guilherme Pacheco
 */
@Repository
public class ServiceRepository {

  @Autowired
  private ServiceMapper serviceMapper;
  private JdbcTemplate jdbcTemplate;

  private static final String INSERT_SQL = "insert into service (name, description) values (?,?)";

  @Autowired
  public ServiceRepository(@ServiceData DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public Optional<Service> findById(Long id) {
    String sql = "select * from service where id = ?";
    ResultSetExtractor<Service> rse = serviceMapper;
    return Optional.ofNullable(jdbcTemplate.query(sql, new Object[] { id }, rse));
  }

  public void udpate(Service service) {

  }

  public void save(Service service) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(conn -> {
      PreparedStatement ps = conn.prepareStatement(INSERT_SQL, new String[] { "id" });
      ps.setString(1, service.getName());
      ps.setString(2, service.getDescription());
      return ps;
    } , keyHolder);
    service.setId(keyHolder.getKey().longValue());
  }

  public void delete(Service service) {

  }

  public List<Service> findAll() {
    return null;
  }

}
