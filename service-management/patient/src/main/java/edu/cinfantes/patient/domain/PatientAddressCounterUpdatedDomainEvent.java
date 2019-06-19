package edu.cinfantes.patient.domain;

public final class PatientAddressCounterUpdatedDomainEvent extends DomainEvent {
  public PatientAddressCounterUpdatedDomainEvent() {
    super(null, "cinfantes.patient.1.event.patient.addresses.counter.updated");
  }
}