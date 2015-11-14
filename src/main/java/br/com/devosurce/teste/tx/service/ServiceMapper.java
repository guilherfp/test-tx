package br.com.devosurce.teste.tx.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * @author Guilherme Pacheco
 */
@Component
public class ServiceMapper implements RowMapper<Service>, ResultSetExtractor<Service> {

  private QService qSerivce;

  public ServiceMapper() {
    qSerivce = new QService();
  }

  @Override
  public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
    return map(rs);
  }

  @Override
  public Service extractData(ResultSet rs) throws SQLException, DataAccessException {
    return map(rs);
  }

  private Service map(ResultSet rs) throws SQLException {
    return rs.next() ? build(rs) : null;
  }

  private Service build(ResultSet rs) throws SQLException {
    Service service = new Service();
    service.setId(rs.getLong(qSerivce.id));
    service.setName(rs.getString(qSerivce.name));
    service.setDescription(rs.getString(qSerivce.description));
    return service;
  }

}
