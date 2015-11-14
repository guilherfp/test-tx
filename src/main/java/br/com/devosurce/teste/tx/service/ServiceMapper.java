package br.com.devosurce.teste.tx.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * @author Guilherme Pacheco
 */
@Component
public class ServiceMapper {

  @Autowired
  private ServiceClient serviceRestClient;
  private QService qSerivce = new QService();

  public RowMapper<Service> mapper() {
    return (rs, rowNum) -> map(rs);
  }

  public ResultSetExtractor<Service> resultSet() {
    return (rs) -> map(rs);
  }

  private Service map(ResultSet rs) throws SQLException {
    return rs.next() ? build(rs) : null;
  }

  private Service build(ResultSet rs) throws SQLException {
    Service service = new Service();
    service.setId(rs.getLong(qSerivce.id));
    service.setName(rs.getString(qSerivce.name));
    service.setDescription(rs.getString(qSerivce.description));
    service.setRestClient(serviceRestClient);
    return service;
  }

}
