package edu.cinfantes.patient.domain;

import java.util.Map;

public class PatientCreatedDomainEvent extends PatientDomainEvent {
  private static final String TYPE = "cinfantes.patient.1.event.patient.created";

  public PatientCreatedDomainEvent(String aggregateId, Map<String, Object> data) {
    super(aggregateId, TYPE, data);
  }

  @Override
  public String getType() {
    return TYPE;
  }
}
