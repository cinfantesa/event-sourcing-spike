package edu.cinfantes.patient.domain;

import lombok.Data;

import static java.util.Objects.requireNonNull;

@Data
public class PatientAddress {
  private String address;
  private String locality;

  public PatientAddress(String address, String locality) {
    requireNonNull(address);
    requireNonNull(locality);

    this.address = address;
    this.locality = locality;
  }
}
