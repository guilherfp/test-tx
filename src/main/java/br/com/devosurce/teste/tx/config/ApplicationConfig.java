package br.com.devosurce.teste.tx.config;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Guilherme Pacheco
 */
@EnableWebMvc
@Configuration
@ComponentScan("br.com.devosurce.teste.tx")
public class ApplicationConfig {

}
