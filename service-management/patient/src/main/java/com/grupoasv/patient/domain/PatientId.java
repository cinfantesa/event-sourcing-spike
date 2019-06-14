package com.grupoasv.patient.domain;

import lombok.Getter;

import java.util.UUID;

import static java.util.UUID.randomUUID;

@Getter
public final class PatientId {
  private UUID id;

  public PatientId() {
    id = randomUUID();
  }
}
