package edu.cinfantes.patient.domain;

import edu.cinfantes.shared.domain.DomainEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class PatientCreatedDomainEvent extends DomainEvent<PatientCreatedAttributes> {
  public static final String TYPE = "cinfantes.patient.1.event.patient.created";

  public PatientCreatedDomainEvent(PatientCreatedAttributes data) {
    super(data, TYPE);
  }
}

