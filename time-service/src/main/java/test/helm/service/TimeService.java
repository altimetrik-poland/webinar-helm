package test.helm.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TimeService {

  private DateTimeFormatter formatter;

  @Autowired
  void setTimePattern(@Value("${time-service.pattern}") String pattern) {
    formatter = DateTimeFormatter
        .ofPattern(pattern)
        .withLocale(Locale.ENGLISH)
        .withZone(ZoneId.systemDefault());
  }

  public String currentTime() {
    log.trace("currentTime()");
    return formatter.format(Instant.now());
  }
}
