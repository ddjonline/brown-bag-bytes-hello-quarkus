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
