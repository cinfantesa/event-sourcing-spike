package edu.cinfantes.patientaddress.domain;

import lombok.Getter;

import java.util.UUID;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public final class PatientId {
  @Getter
  private UUID value;

  public PatientId() {
    value = randomUUID();
  }

  public PatientId(String uuid) {
    requireNonNull(uuid);
    value = fromString(uuid);
  }
}
