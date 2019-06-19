package edu.cinfantes.patientaddress.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class PatientAddressAddedDomainEvent extends DomainEvent<PatientAddressAddedAttributes> {
  public static final String TYPE = "cinfantes.patient.1.event.patient.address.added";

  public PatientAddressAddedDomainEvent(PatientAddressAddedAttributes data) {
    super(data, TYPE);
  }
}

