package br.com.devosurce.teste.tx.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.devosurce.teste.tx.config.ApplicationConfig;

/**
 * @author Guilherme Pacheco
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ServiceRepositoryTest {

  @Autowired
  private ServiceRepository serviceRepository;

  @Test
  public void testFindById() throws Exception {
    Service service = new Service("Service 01");
    serviceRepository.save(service);
    assertNotNull(service.getId());
    assertEquals(service, serviceRepository.findById(service.getId()).get());
  }

}
