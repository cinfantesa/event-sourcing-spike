package edu.cinfantes.patient.domain;

import edu.cinfantes.patient.domain.event.PatientAddressCounterUpdatedAttributes;
import edu.cinfantes.patient.domain.event.PatientAddressCounterUpdatedDomainEvent;
import edu.cinfantes.patient.domain.event.PatientCreatedAttributes;
import edu.cinfantes.patient.domain.event.PatientCreatedDomainEvent;
import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.patient.PatientId;
import org.joda.time.DateTime;

import java.util.Objects;

class PatientState {

  static void apply(Patient patient, DomainEvent event) {
    if (Objects.equals(event.getType(), PatientCreatedDomainEvent.TYPE)) {
      applyPatientCreated(patient, event);
    } else if (Objects.equals(event.getType(), PatientAddressCounterUpdatedDomainEvent.TYPE)) {
      applyPatientAddressAdded(patient, event);
    }
  }

  private static void applyPatientAddressAdded(Patient patient, DomainEvent<PatientAddressCounterUpdatedAttributes> event) {
    int numberOfAddresses = patient.getNumberOfAddresses();
    patient.setNumberOfAddresses(++numberOfAddresses);
  }

  private static void applyPatientCreated(Patient patient, DomainEvent<PatientCreatedAttributes> event) {
    patient.setId(new PatientId(event.getAttributes().getId()));
    patient.setSip(new PatientSip(event.getAttributes().getSip()));
    patient.setPersonalInfo(PatientPersonalInfo.builder()
      .birthDate(new DateTime(event.getAttributes().getBirthDate()))
      .name(event.getAttributes().getName())
      .firstSurname(event.getAttributes().getFirstSurname())
      .secondSurname(event.getAttributes().getSecondSurname())
      .build()
    );
    patient.setComment(new PatientComment(event.getAttributes().getComment()));
  }
}
