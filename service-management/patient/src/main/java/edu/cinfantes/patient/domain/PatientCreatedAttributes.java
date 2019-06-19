package edu.cinfantes.patient.domain;

import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@Builder
public final class PatientCreatedAttributes implements Identifiable {
  private String id;
  private Integer sip;
  private String name;
  private String firstSurname;
  private String secondSurname;
  private DateTime birthDate;
  private String comment;
  private String numberOfAddresses;
}
