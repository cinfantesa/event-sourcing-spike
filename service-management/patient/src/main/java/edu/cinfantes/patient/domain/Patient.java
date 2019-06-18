package edu.cinfantes.patient.domain;

import lombok.Getter;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Getter
public final class Patient {
  private PatientId id;
  private PatientSip sip;
  private PatientPersonalInfo personalInfo;
  private PatientComment comment;
  private List<PatientAddress> addresses;

  private List<DomainEvent> events;

  public Patient(PatientId id, PatientSip sip, PatientPersonalInfo personalInfo, PatientComment comment) {
    this.id = id;
    this.sip = sip;
    this.personalInfo = personalInfo;
    this.comment = comment;
    addresses = new ArrayList<>();
    events = new ArrayList<>();

    events.add(new PatientCreatedDomainEvent(id.getValue().toString(), PatientCreatedPayload.builder()
      .sip(sip)
      .name(personalInfo.getName())
      .firstSurname(personalInfo.getFirstSurname())
      .secondSurname(personalInfo.getSecondSurname())
      .birthDate(personalInfo.getBirthDate())
      .comment(comment.getValue())
      .build()));
  }

  public Patient(Stream<DomainEvent> eventStream) {
    addresses = new ArrayList<>();
    events = new ArrayList<>();

    eventStream.forEach((event) -> {
      if (event instanceof PatientCreatedDomainEvent) {
        apply((PatientCreatedDomainEvent) event);
      } else if (event instanceof  PatientAddressAddedDomainEvent) {
        apply((PatientAddressAddedDomainEvent) event);
      }
    });
  }

  private void apply(PatientAddressAddedDomainEvent event) {
    PatientAddress patientAddress = new PatientAddress(event.getData().getAddress(), event.getData().getLocality());
    addresses.add(patientAddress);
  }

  private void apply(PatientCreatedDomainEvent event) {
    id = new PatientId(event.getAggregateId());
    sip = PatientSip.copyOf(event.getData().getSip());
    personalInfo = PatientPersonalInfo.builder()
      .birthDate(new DateTime(event.getData().getBirthDate()))
      .name(event.getData().getName())
      .firstSurname(event.getData().getFirstSurname())
      .secondSurname(event.getData().getSecondSurname())
      .build();
    comment = new PatientComment(event.getData().getComment());
  }

  public List<DomainEvent> pullDomainEvents() {
    List<DomainEvent> allDomainEvents = List.copyOf(events);
    events.clear();

    return allDomainEvents;
  }

  public void addAddress(PatientAddress patientAddress) {
    addresses.add(patientAddress);

    events.add(new PatientAddressAddedDomainEvent(id.getValue().toString(), PatientAddressAddedPayload.builder()
      .address(patientAddress.getAddress())
      .locality(patientAddress.getLocality())
      .build()));
  }
}
