package br.com.devosurce.teste.tx.service;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.devosurce.teste.tx.config.WebAppConfig;

/**
 * @author Guilherme Pacheco
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfig.class)
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

  @Test
  public void testUdpate() throws Exception {
    Service service = new Service("Service 01");
    serviceRepository.save(service);
    Optional<Service> opService = serviceRepository.findById(service.getId());
    assertTrue(opService.isPresent());
    opService.ifPresent(s -> s.setName("Service 99"));
    serviceRepository.udpate(service);
  }

}
