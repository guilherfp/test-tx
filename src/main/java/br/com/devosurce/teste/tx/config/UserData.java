package br.com.devosurce.teste.tx.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Guilherme Pacheco
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE,
    ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface UserData {

}
