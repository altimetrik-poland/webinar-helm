package test.helm.config;

import java.security.Security;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate defaultRestTemplate(RestTemplateBuilder restTemplateBuilder) {
    Security.setProperty("networkaddress.cache.ttl", "0");
    return restTemplateBuilder.build();
  }
}
