package edu.cinfantes.patient.domain;

import edu.cinfantes.patient.domain.event.PatientAddressCounterUpdatedAttributes;
import edu.cinfantes.patient.domain.event.PatientAddressCounterUpdatedDomainEvent;
import edu.cinfantes.patient.domain.event.PatientCreatedAttributes;
import edu.cinfantes.patient.domain.event.PatientCreatedDomainEvent;
import edu.cinfantes.patient.domain.event.PatientExitedAttributes;
import edu.cinfantes.patient.domain.event.PatientExitedDomainEvent;
import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.patient.AggregateRoot;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.stream.Stream;

@Data
public final class Patient extends AggregateRoot {
  private PatientId id;
  private PatientSip sip;
  private PatientPersonalInfo personalInfo;
  private PatientComment comment;
  private int numberOfAddresses = 0;
  private DateTime leavingDate;

  public Patient(PatientId id, PatientSip sip, PatientPersonalInfo personalInfo, PatientComment comment) {
    this.id = id;
    this.sip = sip;
    this.personalInfo = personalInfo;
    this.comment = comment;

    addDomainEvent(new PatientCreatedDomainEvent(PatientCreatedAttributes.builder()
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
    eventStream.forEach(event-> PatientState.apply(this, event));
  }

  public void addNewPatientAddress() {
    numberOfAddresses++;

    addDomainEvent(new PatientAddressCounterUpdatedDomainEvent(PatientAddressCounterUpdatedAttributes.builder()
      .id(id.getValue())
      .build()));
  }

  public void patientExitus() {
    leavingDate = DateTime.now();

    addDomainEvent(new PatientExitedDomainEvent(PatientExitedAttributes.builder()
            .id(id.getValue())
            .build()));
  }
}
