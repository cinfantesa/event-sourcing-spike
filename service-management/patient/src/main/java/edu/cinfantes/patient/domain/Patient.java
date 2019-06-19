package edu.cinfantes.patient.domain;

import edu.cinfantes.patient.domain.event.DomainEvent;
import lombok.Getter;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
public final class Patient {
  private PatientId id;
  private PatientSip sip;
  private PatientPersonalInfo personalInfo;
  private PatientComment comment;
  private int numberOfAddresses = 0;
  private List<DomainEvent> events;

  public Patient(PatientId id, PatientSip sip, PatientPersonalInfo personalInfo, PatientComment comment) {
    this.id = id;
    this.sip = sip;
    this.personalInfo = personalInfo;
    this.comment = comment;
    events = new ArrayList<>();

    events.add(new PatientCreatedDomainEvent(PatientCreatedAttributes.builder()
      .id(id.getValue())
      .sip(sip.getValue())
      .name(personalInfo.getName())
      .firstSurname(personalInfo.getFirstSurname())
      .secondSurname(personalInfo.getSecondSurname())
      .birthDate(personalInfo.getBirthDate())
      .comment(comment.getValue())
      .build()));
  }

  public Patient(Stream<DomainEvent> eventStream) {
    events = new ArrayList<>();

    eventStream.forEach((event) -> {
      if (Objects.equals(event.getType(), PatientCreatedDomainEvent.TYPE)) {
        apply(event);
      } else if (Objects.equals(event.getType(), PatientAddressCounterUpdatedDomainEvent.TYPE)) {
        apply();
      }
    });
  }

  private void apply() {
    numberOfAddresses++;
  }

  private void apply(DomainEvent<PatientCreatedAttributes> event) {
    id = new PatientId(event.getAttributes().getId());
    sip = new PatientSip(event.getAttributes().getSip());
    personalInfo = PatientPersonalInfo.builder()
      .birthDate(new DateTime(event.getAttributes().getBirthDate()))
      .name(event.getAttributes().getName())
      .firstSurname(event.getAttributes().getFirstSurname())
      .secondSurname(event.getAttributes().getSecondSurname())
      .build();
    comment = new PatientComment(event.getAttributes().getComment());
  }

  public List<DomainEvent> pullDomainEvents() {
    List<DomainEvent> allDomainEvents = List.copyOf(events);
    events.clear();

    return allDomainEvents;
  }

  public void addNewPatientAddress() {
    numberOfAddresses++;

    events.add(new PatientAddressCounterUpdatedDomainEvent(PatientAddressCounterUpdatedAttributes.builder()
      .id(id.getValue())
      .build()));
  }
}
