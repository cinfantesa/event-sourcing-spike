package edu.cinfantes.service.application;

import edu.cinfantes.shared.domain.EventBus;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CancelServicesRelatedToExitedPatient {
  private EventBus eventBus;

  public void invoke(PatientId id) {
    //Get services from patient

    //Verify requirements (states in ACTIVE, INACTIVE, CANCELLED, FINISHED

    //Create cancel event for every service
  }
}
