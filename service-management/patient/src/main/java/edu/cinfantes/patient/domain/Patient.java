package edu.cinfantes.patient.domain;

import edu.cinfantes.shared.domain.patient.AggregateRoot;
import edu.cinfantes.patient.domain.event.PatientAddressCounterUpdatedAttributes;
import edu.cinfantes.patient.domain.event.PatientAddressCounterUpdatedDomainEvent;
import edu.cinfantes.patient.domain.event.PatientCreatedAttributes;
import edu.cinfantes.patient.domain.event.PatientCreatedDomainEvent;
import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.Getter;
import org.joda.time.DateTime;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
public final class Patient extends AggregateRoot {
  private PatientId id;
  private PatientSip sip;
  private PatientPersonalInfo personalInfo;
  private PatientComment comment;
  private int numberOfAddresses = 0;

  public Patient(PatientId id, PatientSip sip, PatientPersonalInfo personalInfo, PatientComment comment) {
    this.id = id;
    this.sip = sip;
    this.personalInfo = personalInfo;
    this.comment = comment;

    addDaomainEvent(new PatientCreatedDomainEvent(PatientCreatedAttributes.builder()
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
    eventStream.forEach((event) -> {
      if (Objects.equals(event.getType(), PatientCreatedDomainEvent.TYPE)) {
        applyPatientCreated(event);
      } else if (Objects.equals(event.getType(), PatientAddressCounterUpdatedDomainEvent.TYPE)) {
        applyPatientAddressAdded(event);
      }
    });
  }

  private void applyPatientAddressAdded(DomainEvent<PatientAddressCounterUpdatedAttributes> event) {
      numberOfAddresses++;
  }

  private void applyPatientCreated(DomainEvent<PatientCreatedAttributes> event) {
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

  public void addNewPatientAddress() {
    numberOfAddresses++;

    addDaomainEvent(new PatientAddressCounterUpdatedDomainEvent(PatientAddressCounterUpdatedAttributes.builder()
      .id(id.getValue())
      .build()));
  }
}
