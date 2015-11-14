package br.com.devosurce.teste.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import br.com.devosurce.teste.tx.config.WebAppConfig;

/**
 * @author Guilherme Pacheco
 */
@EnableAutoConfiguration
@Import(WebAppConfig.class)
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }

}
