package br.com.devosurce.teste.tx;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.devosurce.teste.tx.config.WebAppConfig;

/**
 * @author Guilherme Pacheco
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfig.class)
@TransactionConfiguration(defaultRollback = true)
public abstract class AbstractTest {

}
