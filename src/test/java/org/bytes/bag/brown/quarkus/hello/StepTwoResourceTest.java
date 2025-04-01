package org.bytes.bag.brown.quarkus.hello;

import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;

@QuarkusTest
class StepTwoResourceTest {
  @Test
  void test_getBasicGreeting() {
    given()
        .when().get("/step2")
        .then()
        .statusCode(200)
        .body(is("Hello, Quarkus"));
  }
}