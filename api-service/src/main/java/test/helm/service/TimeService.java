package test.helm.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TimeService {

  private String url;

  @Autowired
  void setUrl(
      @Value("${api-service.time-service-uri}") String uri,
      @Value("${api-service.time-service-path}") String path
  ) {
    url = uri + path;
  }

  @SneakyThrows({
      URISyntaxException.class,
      IOException.class,
      InterruptedException.class
  })
  public String currentTime() {
    log.info("Invoking: {}", url);

    HttpClient client = HttpClient.newBuilder()
        .version(Version.HTTP_2)
        .followRedirects(Redirect.NORMAL)
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI(url))
        .GET()
        .timeout(Duration.ofSeconds(1))
        .build();

    return client.send(request, BodyHandlers.ofString()).body();
  }
}
