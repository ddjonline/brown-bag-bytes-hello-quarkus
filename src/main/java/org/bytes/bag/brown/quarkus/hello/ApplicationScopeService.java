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
