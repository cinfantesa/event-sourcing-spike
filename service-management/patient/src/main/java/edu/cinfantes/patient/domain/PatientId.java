package edu.cinfantes.patient.domain;

import lombok.Getter;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public final class PatientId {
  @Getter
  private String value;

  public PatientId() {
    value = randomUUID().toString();
  }

  public PatientId(String uuid) {
    requireNonNull(uuid);
    value = fromString(uuid).toString();
  }
}
