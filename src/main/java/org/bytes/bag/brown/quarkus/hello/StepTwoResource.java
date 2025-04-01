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
