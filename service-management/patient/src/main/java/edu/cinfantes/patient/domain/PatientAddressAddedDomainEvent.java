package edu.cinfantes.patient.domain;

import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class PatientAddressAddedDomainEvent extends PatientDomainEvent {
  private static final String TYPE = "cinfantes.patient.1.event.patient.address.added";

  public PatientAddressAddedDomainEvent(String aggregateId, Map<String, Object> data) {
    super(aggregateId, TYPE, data);
  }

  @Override
  public String getType() {
    return TYPE;
  }
}
