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
