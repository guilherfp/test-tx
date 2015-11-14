package br.com.devosurce.teste.tx.config;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Guilherme Pacheco
 */
@EnableWebMvc
@ComponentScan("br.com.devosurce.teste.tx")
public class WebAppConfig {

  private static final String BROKER_URL = "tcp://localhost:61616";

  private BrokerService broker;

  public WebAppConfig() throws Exception {
    broker = new BrokerService();
    broker.addConnector(BROKER_URL);
    broker.start();
  }

}
