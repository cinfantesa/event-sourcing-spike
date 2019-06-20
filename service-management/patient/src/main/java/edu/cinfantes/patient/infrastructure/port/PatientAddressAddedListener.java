package edu.cinfantes.patient.infrastructure.port;

import edu.cinfantes.patient.application.UpdateNumberOfAddresses;
import edu.cinfantes.patient.domain.event.PatientAddressAddedDomainEvent;
import edu.cinfantes.patient.infrastructure.event.PatientAddressAddedProcessor;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(PatientAddressAddedProcessor.class)
@AllArgsConstructor
public class PatientAddressAddedListener {
  private final UpdateNumberOfAddresses updateNumberOfAddresses;

  @StreamListener(PatientAddressAddedProcessor.ON_CLIENT_ADDRESS_ADDED)
  public void processOrder(PatientAddressAddedDomainEvent event) {
    PatientId patientId = new PatientId(event.getData().getAttributes().getPatientId().getValue());
    updateNumberOfAddresses.invoke(patientId);
  }

}
