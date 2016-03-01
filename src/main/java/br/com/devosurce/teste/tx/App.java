package br.com.devosurce.teste.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Guilherme Pacheco
 */
@ComponentScan
@EnableAutoConfiguration
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

}
