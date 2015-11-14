package br.com.devosurce.teste.tx.user;

import java.util.Objects;

import org.apache.commons.lang3.Validate;

import br.com.devosurce.teste.tx.service.Service;

/**
 * @author Guilherme Pacheco
 */
public class User {

  private Long id;
  private String name;
  private String username;
  private Service service;

  public User(String username) {
    setUsername(username);
  }

  public Long getId() {
    return id;
  }

  void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    Validate.notBlank(username);
    this.username = username;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    User other = (User) obj;
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("User [id: %s, name: %s, username: %s]", id, name, username);
  }

}
