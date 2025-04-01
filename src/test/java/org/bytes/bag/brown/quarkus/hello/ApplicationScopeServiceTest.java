package org.bytes.bag.brown.quarkus.hello;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ApplicationScopeServiceTest {

  @Inject
  private ApplicationScopeService service;

  @Test
  void test_getNumber_shouldStayTheSame() {
    String firstAnswer = service.getNumber();
    String secondAnswer = service.getNumber();

    assertEquals(firstAnswer, secondAnswer);
  }
}