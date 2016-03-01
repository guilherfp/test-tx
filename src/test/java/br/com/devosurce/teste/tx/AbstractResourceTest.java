package br.com.devosurce.teste.tx;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Guilherme Pacheco
 */
public abstract class AbstractResourceTest extends AbstractTest {

  private MockMvc mockMvc;
  private HttpMessageConverter<Object> messageConverter;

  protected static MediaType JSON_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(),
    MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

  @Autowired
  private WebApplicationContext context;

  @Before
  public void setRecallTestUp() throws Exception {
    mockMvc = webAppContextSetup(context).build();
    messageConverter = new MappingJackson2HttpMessageConverter();
  }

  public MockMvc mockMvc() {
    return mockMvc;
  }

  public HttpMessageConverter<Object> messageConverter() {
    return messageConverter;
  }

  protected final String json(Object o) throws IOException {
    MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
    messageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
    return mockHttpOutputMessage.getBodyAsString();
  }
}
