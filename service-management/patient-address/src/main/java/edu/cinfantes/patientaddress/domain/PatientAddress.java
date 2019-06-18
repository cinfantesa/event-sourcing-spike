package edu.cinfantes.patientaddress.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Getter
public class PatientAddress {
  private PatientAddressId id;
  private PatientId patientId;

  private String address;
  private String locality;

  private List<DomainEvent> events;

  public PatientAddress(PatientAddressId id, PatientId patientId, String address, String locality) {
    requireNonNull(address);
    requireNonNull(locality);

    events = new ArrayList<>();

    this.id = id;
    this.address = address;
    this.locality = locality;
    this.patientId = patientId;

    events.add(new PatientAddressAddedDomainEvent(id.getValue().toString(), PatientAddressAddedPayload.builder()
      .address(address)
      .locality(locality)
      .patientId(patientId)
      .build()));
  }

  public List<DomainEvent> pullDomainEvents() {
    List<DomainEvent> allDomainEvents = List.copyOf(events);
    events.clear();

    return allDomainEvents;
  }
}
