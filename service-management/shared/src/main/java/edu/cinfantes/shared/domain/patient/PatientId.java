package edu.cinfantes.shared.domain.patient;

import lombok.Data;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

@Data
public final class PatientId {
  private String value;

  public PatientId() {
    value = randomUUID().toString();
  }

  public PatientId(String uuid) {
    requireNonNull(uuid);
    value = fromString(uuid).toString();
  }
}
