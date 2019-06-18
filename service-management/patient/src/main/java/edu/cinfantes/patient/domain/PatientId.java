package edu.cinfantes.patient.domain;

import java.util.UUID;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public final class PatientId {
  private UUID id;

  public PatientId() {
    id = randomUUID();
  }

  public PatientId(String uuid) {
    requireNonNull(uuid);
    id = fromString(uuid);
  }

  public UUID value() {
    return id;
  }
}
