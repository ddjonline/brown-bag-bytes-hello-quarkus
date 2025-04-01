# Step 3 ( Use Context Injection)

If you do not already have the Quarkus Dev UI running, start it again with the command `mvn quarkus:dev` and navigate your browser to <http://localhost:8080/q/dev-ui> to view the status of your Quarkus application.

## Services

Let's create two very basic services that will each return a string of text containing a random number.

### Application Scoped Service

This first service should be created just once and the random number value should stay the same every time the `getNumber` method is called.

In the `src\main\java\org\bytes\bag\brown\quarkus\hello` directory create a new file called `ApplicationScopeService.java` with the following contents:

```java
package org.bytes.bag.brown.quarkus.hello;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationScopeService {
  
  double randomNumber; 

  public ApplicationScopeService() {
    randomNumber = java.lang.Math.random();
  }

  public String getNumber() {
    return String.valueOf(randomNumber);
  }
}
```

### Request Scoped Service

This second service should be created on every new request and the random number value should be new every time the `getNumber` method is called.

In the `src\main\java\org\bytes\bag\brown\quarkus\hello` directory create a new file called `RequestScopeService.java` with the following contents:

```java
package org.bytes.bag.brown.quarkus.hello;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopeService {

  double randomNumber;

  public RequestScopeService() {
    randomNumber = java.lang.Math.random();
  }

  public String getNumber() {
    return String.valueOf(randomNumber);
  }
}
```

## Unit Tests

In the `src\test\java\org\bytes\bag\brown\quarkus\hello` directory create a new file called `ApplicationScopeServiceTest.java` with the following contents:

```java
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
```

In the `src\test\java\org\bytes\bag\brown\quarkus\hello` directory create a new file called `RequestScopeServiceTest.java` with the following contents:

```java
package org.bytes.bag.brown.quarkus.hello;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class RequestScopeServiceTest {
  @Inject
  private RequestScopeService service;

  @Test
  void test_getNumber_shouldStayTheSame() {
    String firstAnswer = service.getNumber();
    String secondAnswer = service.getNumber();

    assertEquals(firstAnswer, secondAnswer);
  }
}
```

## New API Resource to Use the Services

Let's create a new API resource endpoint to utilize these services

In the `src\main\java\org\bytes\bag\brown\quarkus\hello` directory create a new file called `StepThreeResource.java` with the following contents:

```java
package org.bytes.bag.brown.quarkus.hello;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/step3")
public class StepThreeResource {

  private final ApplicationScopeService applicationScopeService;
  private final RequestScopeService requestScopeService;

  public StepThreeResource(ApplicationScopeService applicationScopeService, RequestScopeService requestScopeService) {
    this.applicationScopeService = applicationScopeService;
    this.requestScopeService = requestScopeService;
  }

  @GET
  @Path("/")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes("*/*")
  public String getBasicGreeting() {
    return String.format("The numbers are stable: %s and request: %s", applicationScopeService.getNumber(), requestScopeService.getNumber());
  }
}
```

Refresh your Quarkus DEV UI navigate to <http://localhost:8080/q/dev-ui/endpoints> and you should now see an entry for the newly added `/step3` endpoint. If you then click on the entry or navigate your browser to <http://localhost:8080/step3> you should see the new greetings with contents similar to `The numbers are stable: 0.3208329124088912 and request: 0.043496244514190874`. Every time you refresh the browser page, the first number should stay the same but the second number should be new.

## Next...

Next step is to test how the application is used as if it were deployed => [Step 4](README_STEP_4.md)
