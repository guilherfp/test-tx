package br.com.devosurce.teste.tx.service;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import br.com.devosurce.teste.tx.AbstractTest;

/**
 * @author Guilherme Pacheco
 */
public class ServiceRepositoryTest extends AbstractTest {

  @Autowired
  private ServiceRepository serviceRepository;

  @Test
  @Rollback
  public void testFindById() throws Exception {
    Service service = new Service("Service 01");
    serviceRepository.save(service);
    assertNotNull(service.getId());
    assertEquals(service, serviceRepository.findById(service.getId()).get());
  }

  @Test
  @Rollback
  public void testUdpate() throws Exception {
    Service service = new Service("Service 01");
    serviceRepository.save(service);
    Optional<Service> opService = serviceRepository.findById(service.getId());
    assertTrue(opService.isPresent());
    opService.ifPresent(s -> s.setName("Service 99"));
    serviceRepository.udpate(service);
  }

}
