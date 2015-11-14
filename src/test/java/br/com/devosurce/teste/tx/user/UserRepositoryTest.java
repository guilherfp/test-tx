package br.com.devosurce.teste.tx.user;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import br.com.devosurce.teste.tx.AbstractTest;

/**
 * @author Guilherme Pacheco
 */
@UserTx
public class UserRepositoryTest extends AbstractTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  @Rollback
  public void testSave() throws Exception {
    User user = userRepository.save(new User("test"));
    assertEquals(user, userRepository.findById(user.getId()));
  }

  @Test
  @Rollback
  public void testFindById() throws Exception {
    User user = userRepository.save(new User("test"));
    assertEquals(user, userRepository.findById(user.getId()));
  }

  @Test
  @Rollback
  public void testUpdate() throws Exception {
    User user = userRepository.save(new User("test"));
    User byId = userRepository.findById(user.getId());
    byId.setName("test1");
    userRepository.update(byId);
    assertEquals("test1", userRepository.findById(user.getId()).getName());
  }

  @Test
  @Rollback
  public void testFindAll() throws Exception {
    userRepository.save(Arrays.asList(new User("test"), new User("test1"), new User("test2")));
    List<User> all = userRepository.findAll();
    assertNotNull(all);
    assertEquals(3, all.size());
  }

  @Test
  @Rollback
  public void testDelete() throws Exception {
    User user = new User("test");
    userRepository.save(user);
    List<User> all = userRepository.findAll();
    assertNotNull(all);
    userRepository.delete(user);
    assertEquals(all.size() - 1, userRepository.findAll().size());
  }

}
