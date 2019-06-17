package edu.cinfantes.patient.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class PatientComment {
  private String comment;

  public String value() {
    return comment;
  }
}
