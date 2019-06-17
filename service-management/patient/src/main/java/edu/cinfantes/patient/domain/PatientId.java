package edu.cinfantes.patient.domain;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public final class PatientId {
  private UUID id;

  public PatientId() {
    id = randomUUID();
  }

  public UUID value() {
    return id;
  }
}
