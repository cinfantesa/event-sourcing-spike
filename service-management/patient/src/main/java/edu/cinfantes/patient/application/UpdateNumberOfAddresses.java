package edu.cinfantes.patient.application;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.EventBus;
import edu.cinfantes.patient.domain.Patient;
import edu.cinfantes.patient.domain.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class UpdateNumberOfAddresses {
  private EventBus eventBus;

  public void invoke(PatientId id) {
    Stream<DomainEvent> domainEventStream = eventBus.loadEventStream(id.getValue().toString());

    Patient patient = new Patient(domainEventStream);
    patient.addNewPatientAddress();
  }
}
