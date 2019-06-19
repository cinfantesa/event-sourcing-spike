package edu.cinfantes.patient.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PatientAddressCounterUpdatedDomainEvent extends PatientDomainEvent {

  public PatientAddressCounterUpdatedDomainEvent(String aggregateId) {
    super(aggregateId, null);

    type = "cinfantes.patient.1.event.patient.addresses.counter.updated";
  }
}