package test.helm.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.helm.service.TimeService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/time")
public class TimeController {

  private final TimeService service;
  private String podPrefix;

  @Autowired
  void setHost(@Value("${time-service.pod-prefix:false}") boolean enabled)
      throws UnknownHostException {
    podPrefix = enabled ? InetAddress.getLocalHost().getHostName() + ": " : "";
  }

  @GetMapping
  public String currentTime() {
    String currentTime = service.currentTime();
    log.debug("currentTime() = {}", currentTime);
    return podPrefix + currentTime;
  }

}
