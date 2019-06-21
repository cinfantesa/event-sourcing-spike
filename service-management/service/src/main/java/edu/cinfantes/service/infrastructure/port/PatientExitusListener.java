package edu.cinfantes.service.infrastructure.port;

import edu.cinfantes.patient.domain.event.PatientExitedDomainEvent;
import edu.cinfantes.service.application.CancelServicesRelatedToExitedPatient;
import edu.cinfantes.service.infrastructure.event.PatientExitedProcessor;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(PatientExitedProcessor.class)
@AllArgsConstructor
public class PatientExitusListener {
  private final CancelServicesRelatedToExitedPatient cancelServicesRelatedToExitedPatient;

  @StreamListener(PatientExitedProcessor.ON_PATIENT_EXITED)
  public void processOrder(PatientExitedDomainEvent event) {
    PatientId patientId = new PatientId(event.getData().getAttributes().getId());

    cancelServicesRelatedToExitedPatient.invoke(patientId);
  }

}
