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

  private static final String SELECT_ALL_SQL = "select * from service";
  private static final String SELECT_SQL = "select * from service where id = ?";
  private static final String INSERT_SQL = "insert into service (name, description) values (?,?)";
  private static final String UPDATE_SQL = "update service set name = ?, description = ? where id = ?";

  @Autowired
  public ServiceRepository(@ServiceData DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public Optional<Service> findById(Long id) {
    ResultSetExtractor<Service> rse = serviceMapper;
    return Optional.ofNullable(jdbcTemplate.query(SELECT_SQL, new Object[] { id }, rse));
  }

  public void udpate(Service service) {
    jdbcTemplate.update(conn -> {
      PreparedStatement ps = conn.prepareStatement(UPDATE_SQL);
      ps.setString(1, service.getName());
      ps.setString(2, service.getDescription());
      ps.setLong(3, service.getId());
      return ps;
    });
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
    return jdbcTemplate.query(SELECT_ALL_SQL, serviceMapper);
  }

}
