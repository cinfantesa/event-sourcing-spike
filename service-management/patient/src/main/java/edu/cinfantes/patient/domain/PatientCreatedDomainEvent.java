package edu.cinfantes.patient.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class PatientCreatedDomainEvent extends DomainEvent<PatientCreatedAttributes> {

  public PatientCreatedDomainEvent(PatientCreatedAttributes data) {
    super(data, "cinfantes.patient.1.event.patient.created");
  }
}

