package com.grupoasv.patient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
public final class PatientPersonalInfo {
  private String name;
  private String firstSurname;
  private String secondSurname;
  private DateTime birthDate;
}
