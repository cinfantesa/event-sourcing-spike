package edu.cinfantes.service.domain;

import lombok.Getter;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public class ServiceId {
  @Getter
  private String value;

  public ServiceId() {
    value = randomUUID().toString();
  }

  public ServiceId(String uuid) {
    requireNonNull(uuid);
    value = fromString(uuid).toString();
  }
}
