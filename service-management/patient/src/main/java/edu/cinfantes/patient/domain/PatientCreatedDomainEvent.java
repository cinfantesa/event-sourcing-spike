package edu.cinfantes.patient.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@NoArgsConstructor
public class PatientCreatedDomainEvent extends PatientDomainEvent<PatientCreatedPayload> {

  public PatientCreatedDomainEvent(String aggregateId, PatientCreatedPayload data) {
    super(aggregateId, data);

    type = "cinfantes.patient.1.event.patient.created";
  }
}

@Data
@Builder
class PatientCreatedPayload {
  private PatientSip sip;
  private String name;
  private String firstSurname;
  private String secondSurname;
  private DateTime birthDate;
  private String comment;
}