package edu.cinfantes.service.domain;

import edu.cinfantes.service.domain.event.PatientAddressAddedAttributes;
import edu.cinfantes.service.domain.event.PatientAddressAddedDomainEvent;
import edu.cinfantes.shared.domain.patient.AggregateRoot;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.Getter;

import static java.util.Objects.requireNonNull;

@Getter
public class PatientAddress extends AggregateRoot {
  private PatientAddressId id;
  private PatientId patientId;

  private String address;
  private String locality;

  public PatientAddress(PatientAddressId id, PatientId patientId, String address, String locality) {
    requireNonNull(address);
    requireNonNull(locality);


    this.id = id;
    this.address = address;
    this.locality = locality;
    this.patientId = patientId;

    addDomainEvent(new PatientAddressAddedDomainEvent(PatientAddressAddedAttributes.builder()
      .id(id.getValue())
      .address(address)
      .locality(locality)
      .patientId(patientId)
      .build()));
  }
}
