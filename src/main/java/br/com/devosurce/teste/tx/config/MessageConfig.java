package br.com.devosurce.teste.tx.config;

import java.io.IOException;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Guilherme Pacheco
 */
@Configuration
public class MessageConfig implements InitializingBean, DisposableBean {

  private static final String BROKER_URL = "tcp://localhost:61616";

  private BrokerService broker;

  public MessageConfig() throws Exception {
    broker = new BrokerService();
    broker.addConnector(BROKER_URL);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    broker.start();
  }

  @Override
  public void destroy() throws Exception {
    broker.stop();
  }

  @Bean(destroyMethod = "stop")
  public ConnectionFactory connectionFactory() throws IOException {
    PooledConnectionFactory pooledFactory = new PooledConnectionFactory();
    pooledFactory.setConnectionFactory(new ActiveMQConnectionFactory("vm:localhost:61616"));
    return pooledFactory;
  }

}
