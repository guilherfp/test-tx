package br.com.devosurce.teste.tx.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Guilherme Pacheco
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

  @Bean
  @UserData
  public DataSource userDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    builder.setType(EmbeddedDatabaseType.H2).addScripts("schema1.sql");
    return builder.build();
  }

  @Bean
  @ServiceData
  public DataSource serviceDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    builder.setType(EmbeddedDatabaseType.H2).addScripts("schema2.sql");
    return builder.build();
  }

  @Bean
  @Qualifier("user")
  public DataSourceTransactionManager transactionManager1(@UserData DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  @Qualifier("service")
  public DataSourceTransactionManager transactionManager2(@ServiceData DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}
