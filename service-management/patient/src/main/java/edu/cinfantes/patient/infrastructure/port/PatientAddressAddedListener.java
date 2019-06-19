package edu.cinfantes.patient.infrastructure.port;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cinfantes.patient.application.UpdateNumberOfAddresses;
import edu.cinfantes.patient.infrastructure.event.PatientAddressAddedProcessor;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableBinding(PatientAddressAddedProcessor.class)
@AllArgsConstructor
public class PatientAddressAddedListener {
  private final UpdateNumberOfAddresses updateNumberOfAddresses;

  @StreamListener(PatientAddressAddedProcessor.ON_CLIENT_ADDRESS_ADDED)
  public void processOrder(@Payload String data) throws IOException {
    String aggregateId = new ObjectMapper().readTree(data).get("data").get("patientId").get("value").asText();

    PatientId patientId = new PatientId(aggregateId);
    updateNumberOfAddresses.invoke(patientId);
  }

}
