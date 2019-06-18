package edu.cinfantes.patientaddress.domain;

import lombok.Getter;

import java.util.UUID;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public class PatientAddressId {
  @Getter
  private UUID value;

  public PatientAddressId() {
    value = randomUUID();
  }

  public PatientAddressId(String uuid) {
    requireNonNull(uuid);
    value = fromString(uuid);
  }
}
