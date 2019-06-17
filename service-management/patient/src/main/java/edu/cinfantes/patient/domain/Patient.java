package edu.cinfantes.patient.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public final class Patient {
  private PatientId id;
  private PatientSip sip;
  private PatientPersonalInfo personalInfo;
  private PatientComment comment;

  private List<DomainEvent> events;

  public Patient(PatientId id, PatientSip sip, PatientPersonalInfo personalInfo, PatientComment comment) {
    this.id = id;
    this.sip = sip;
    this.personalInfo = personalInfo;
    this.comment = comment;

    events = new ArrayList<>();

    events.add(new PatientCreatedDomainEvent(id.toString(), Map.of(
      "sip", sip,
      "name", personalInfo.getName(),
      "firstSurname", personalInfo.getFirstSurname(),
      "secondSurname", personalInfo.getSecondSurname(),
      "birthDate", personalInfo.getBirthDate(),
      "comment", comment.value()))
    );
  }


  public List<DomainEvent> pullDomainEvents() {
    List<DomainEvent> allDomainEvents = List.copyOf(events);
    events.clear();

    return allDomainEvents;
  }
}
