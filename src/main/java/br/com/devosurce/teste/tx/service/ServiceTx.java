package br.com.devosurce.teste.tx.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Transactional;

import br.com.devosurce.teste.tx.config.Constants;

/**
 * @author Guilherme Pacheco
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Transactional(Constants.SERVICE)
public @interface ServiceTx {

}
