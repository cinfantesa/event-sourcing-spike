package edu.cinfantes.patient.infrastructure.port;

import edu.cinfantes.patient.domain.event.ServiceAddedDomainEvent;
import edu.cinfantes.patient.infrastructure.event.ServiceAddedProcessor;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(ServiceAddedProcessor.class)
@AllArgsConstructor
public class ServiceAddedListener {

  @StreamListener(ServiceAddedProcessor.ON_SERVICE_ADDED)
  public void processOrder(ServiceAddedDomainEvent event) {
    PatientId patientId = new PatientId(event.getData().getAttributes().getPatientId().getValue());

    //TODO
    //Persist service in locally view
  }
}
