package edu.cinfantes.patientaddress.application;

import edu.cinfantes.patientaddress.domain.PatientAddress;
import edu.cinfantes.patientaddress.domain.PatientAddressId;
import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.EventBus;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public final class CreatePatientAddress {
  private final EventBus eventBus;

  public void invoke(PatientAddressId id, PatientId patientId, String address, String locality) {
    PatientAddress patientAddress = new PatientAddress(id, patientId, address, locality);

    List<DomainEvent> domainEvents = patientAddress.pullDomainEvents();
    eventBus.appendToEventStream(domainEvents);
  }
}
