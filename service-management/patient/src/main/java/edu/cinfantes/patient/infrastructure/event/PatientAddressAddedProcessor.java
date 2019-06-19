package edu.cinfantes.patient.infrastructure.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PatientAddressAddedProcessor {
  String ON_CLIENT_ADDRESS_ADDED = "onPatientAddressAdded";

  @Input
  SubscribableChannel onPatientAddressAdded();
}
