package edu.cinfantes.patient.application;

import edu.cinfantes.patient.domain.EventBus;
import edu.cinfantes.patient.domain.PatientAddress;
import edu.cinfantes.patient.domain.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePatientAddress {
  private final EventBus eventBus;
  public void invoke(PatientId patientId, PatientAddress patientAddress) {
    eventBus.loadDomainEventsStream(patientId.value().toString());
  }
}
