package edu.cinfantes.patient.domain.event;

import edu.cinfantes.shared.domain.DomainEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class PatientExitedDomainEvent extends DomainEvent<PatientExitedAttributes> {
  public static final String TYPE = "cinfantes.patient.1.event.patient.exited";

  public PatientExitedDomainEvent(PatientExitedAttributes data) {
    super(data, TYPE);
  }
}

