package edu.cinfantes.patient.application;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.EventBus;
import edu.cinfantes.patient.domain.Patient;
import edu.cinfantes.patient.domain.PatientAddress;
import edu.cinfantes.patient.domain.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public final class CreatePatientAddress {
  private final EventBus eventBus;

  public void invoke(PatientId patientId, PatientAddress patientAddress) {
    Stream<DomainEvent> domainEventStream = eventBus.loadEventStream(patientId.getValue().toString());

    Patient patient = new Patient(domainEventStream);
    patient.addAddress(patientAddress);

    List<DomainEvent> domainEvents = patient.pullDomainEvents();
    eventBus.appendToEventStream(domainEvents);
  }
}
