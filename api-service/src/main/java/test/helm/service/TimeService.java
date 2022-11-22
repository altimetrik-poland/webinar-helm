package test.helm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class TimeService {

  private final RestTemplate restTemplate;
  private String url;

  @Autowired
  void setUrl(
      @Value("${api-service.time-service-uri}") String uri,
      @Value("${api-service.time-service-path}") String path
  ) {
    url = uri + path;
  }

  public String currentTime() {
    log.info("Invoking: {}", url);
    return restTemplate
        .getForEntity(url, String.class)
        .getBody();
  }
}
