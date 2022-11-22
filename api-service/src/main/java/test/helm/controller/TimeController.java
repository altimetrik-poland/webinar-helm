package test.helm.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.helm.service.TimeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/time")
public class TimeController {

  private final TimeService service;

  @GetMapping
  public String currentTime() {
    return service.currentTime();
  }

}
