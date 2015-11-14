package br.com.devosurce.teste.tx.service;

import java.util.Objects;

import org.apache.commons.lang3.Validate;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Guilherme Pacheco
 */
public class Service {

  @JsonProperty
  private Long id;
  @NotBlank
  @JsonProperty
  private String name;
  @JsonProperty
  private String description;

  Service() {
    super();
  }

  public Service(String name) {
    Validate.notBlank(name);
    this.name = name;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Service other = (Service) obj;
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return String.format("Service [id: %s, name: %s, description: %s]", id, name, description);
  }

}
