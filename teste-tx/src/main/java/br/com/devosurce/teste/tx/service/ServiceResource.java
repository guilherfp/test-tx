package br.com.devosurce.teste.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guilherme Pacheco
 */
@RestController
@RequestMapping("/services")
public class ServiceResource {

  @Autowired
  private ServiceRepository serviceRepository;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Service findById(@PathVariable long id) {
    return serviceRepository.findById(id).get();
  }

}
