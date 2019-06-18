package edu.cinfantes.patient.domain;

import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class PatientCreatedDomainEvent extends DomainEvent {
  private static final String TYPE = "cinfantes.patient.1.event.patient.created";

  public PatientCreatedDomainEvent(String aggregateId, Map<String, Object> data) {
    super(aggregateId, TYPE, data);
  }
}
