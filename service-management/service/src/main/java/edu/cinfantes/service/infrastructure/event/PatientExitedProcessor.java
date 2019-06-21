package edu.cinfantes.service.infrastructure.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PatientExitedProcessor {
  String ON_PATIENT_EXITED = "onPatientExited";

  @Input
  SubscribableChannel onPatientExited();
}
