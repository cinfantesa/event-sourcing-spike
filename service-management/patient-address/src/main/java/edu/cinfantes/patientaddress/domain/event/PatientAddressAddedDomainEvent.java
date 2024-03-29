package edu.cinfantes.patientaddress.domain.event;

import edu.cinfantes.shared.domain.DomainEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class PatientAddressAddedDomainEvent extends DomainEvent<PatientAddressAddedAttributes> {
  public static final String TYPE = "cinfantes.patient.2.event.patient.address.added";

  public PatientAddressAddedDomainEvent(PatientAddressAddedAttributes data) {
    super(data, TYPE);
  }
}

