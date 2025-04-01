# Step 2 (First API Endpoint)

If you do not already have the Quarkus Dev UI running, start it again with the command `mvn quarkus:dev` and navigate your browser to <http://localhost:8080/q/dev-ui> to view the status of your Quarkus application.

## The First API Endpoint

In the `src\main\java\org\bytes\bag\brown\quarkus\hello` directory create a new file called `StepTwoResource.java` with the following contents

```java
package org.bytes.bag.brown.quarkus.hello;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/step2")
public class StepTwoResource {
  
  @GET
  @Path("/")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes("*/*")
  public String getBasicGreeting() {
    return "Hello, Quarkus";
  }
}
```

Refresh your Quarkus DEV UI navigate to <http://localhost:8080/q/dev-ui/endpoints> and you should now see an entry for the newly added `/step2` endpoint. If you then click on the entry or navigate your browser to <http://localhost:8080/step2> you should see the value "Hello, Quarkus" returned in the browser.

## Unit Test

In the `src\test\java\org\bytes\bag\brown\quarkus\hello` directory, create a new file called `StepTwoResourceTest.java` with the following contents:

```java
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
```

In the terminal in which you ran `mvn quarkus:dev` you should see a prompt similar to `Press [e] to edit command line args (currently ''), [r] to re-run, [o] Toggle test output, [:] for the terminal, [h] for more options>`. Press the letter `r` on the keyboard. You should see a message similar to "All 1 test is passing (0 skipped), 1 test was run in 4782ms. Tests completed at 16:52:08." in the terminal.

Back in the browser with the Quarkus DEV UI session, navigate to <http://localhost:8080/q/dev-ui/continuous-testing> and refresh the page. Click the "Start" button and you should now see your test listed and successful.

In the `StepTwoResource.java` file, change the return greeting and verify your test starts to fail. Restore the message to "Hello, Quarkus" and verify it resumes passing.

## Next...

Next step is to leverage the Quarkus Context Injection system to spread out the workload => [Step 3](README_STEP_3.md)
