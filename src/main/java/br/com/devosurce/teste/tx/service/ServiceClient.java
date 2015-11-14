package br.com.devosurce.teste.tx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Guilherme Pacheco
 */
@Component
public class ServiceClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceClient.class);

  public void updateName(long id, String name) {
    LOGGER.info("Atualizando nome do serviço: {}, name: {}", id, name);
  }

}
