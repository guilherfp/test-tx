package br.com.devosurce.teste.tx.service;

import javax.jms.ConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Guilherme Pacheco
 */
@Component
public class ServiceClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceClient.class);
  private static final String QUEUE_NAME = "SERVICE";
  private JmsTemplate jmsTemplate;

  @Autowired
  public ServiceClient(ConnectionFactory connectionFactory) {
    jmsTemplate = new JmsTemplate(connectionFactory);
  }

  public void updateName(long id, String name) {
    LOGGER.info("Atualizando nome do serviço: {}, name: {}", id, name);
    jmsTemplate.send(QUEUE_NAME, session -> {
      ActiveMQMapMessage message = new ActiveMQMapMessage();
      message.setLong("id", id);
      message.setString("name", name);
      return message;
    });
  }

}
