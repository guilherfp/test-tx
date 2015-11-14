package br.com.devosurce.teste.tx.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import br.com.devosurce.teste.tx.AbstractResourceTest;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Guilherme Pacheco
 */
public class ServiceResourceTest extends AbstractResourceTest {

  @Autowired
  private ServiceRepository serviceRepository;

  @Test
  public void testFindById() throws Exception {
    Service service = new Service("service01");
    serviceRepository.save(service);

    String url = "/services/" + service.getId();
    MockHttpServletRequestBuilder request = get(url).contentType(JSON_TYPE);
    mockMvc().perform(request)
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id", is(service.getId().intValue())))
      .andExpect(jsonPath("$.name", is("service01")));
  }

  @Test
  public void testFindById_NoService() throws Exception {
    mockMvc().perform(get("/services/1").contentType(JSON_TYPE)).andExpect(status().isOk());
  }

}
