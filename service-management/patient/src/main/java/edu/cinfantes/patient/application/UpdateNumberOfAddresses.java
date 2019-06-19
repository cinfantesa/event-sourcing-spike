package edu.cinfantes.patient.application;

import edu.cinfantes.patient.domain.Patient;
import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.EventBus;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class UpdateNumberOfAddresses {
  private EventBus eventBus;

  public void invoke(PatientId id) {
    Stream<DomainEvent> domainEventStream = eventBus.loadEventStream(id.getValue());

    Patient patient = new Patient(domainEventStream);
    patient.addNewPatientAddress();

    List<DomainEvent> domainEvents = patient.pullDomainEvents();
    eventBus.appendToEventStream(domainEvents);
  }
}
