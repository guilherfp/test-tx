package br.com.devosurce.teste.tx.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Guilherme Pacheco
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

  @Qualifier(Constants.USER)
  @Bean(name = Constants.USER)
  public DataSource userDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).addScripts("schema1.sql").build();
  }

  @Qualifier(Constants.SERVICE)
  @Bean(name = Constants.SERVICE)
  public DataSource serviceDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).addScripts("schema2.sql").build();
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(@UserData DataSource dataSource) {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setMappingResources("hibernate/user.hbm.xml");
    factory.setDataSource(dataSource);
    return factory;
  }

  @Bean
  @Qualifier(Constants.USER)
  public DataSourceTransactionManager userTransaction(@UserData DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  @Qualifier(Constants.SERVICE)
  public DataSourceTransactionManager serviceTransaction(@ServiceData DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}
