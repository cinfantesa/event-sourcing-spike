package edu.cinfantes.patientaddress.domain;

import lombok.Getter;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

public class PatientAddressId {
  @Getter
  private String value;

  public PatientAddressId() {
    value = randomUUID().toString();
  }

  public PatientAddressId(String uuid) {
    requireNonNull(uuid);
    value = fromString(uuid).toString();
  }
}
