package edu.cinfantes.patient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@Builder
@AllArgsConstructor
public final class PatientPersonalInfo {
  private String name;
  private String firstSurname;
  private String secondSurname;
  private DateTime birthDate;
}
