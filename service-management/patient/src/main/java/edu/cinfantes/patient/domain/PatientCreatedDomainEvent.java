package edu.cinfantes.patient.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@NoArgsConstructor
public final class PatientCreatedDomainEvent extends DomainEvent<PatientCreatedAttributes> {

  public PatientCreatedDomainEvent(PatientCreatedAttributes data) {
    super(data, "cinfantes.patient.1.event.patient.created");
  }
}

@Data
@Builder
class PatientCreatedAttributes implements Identificable{
  private String id;
  private Integer sip;
  private String name;
  private String firstSurname;
  private String secondSurname;
  private DateTime birthDate;
  private String comment;
  private String numberOfAddresses;
}