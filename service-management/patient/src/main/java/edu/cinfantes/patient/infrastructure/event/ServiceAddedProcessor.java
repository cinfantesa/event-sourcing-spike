package edu.cinfantes.patient.infrastructure.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ServiceAddedProcessor {
  String ON_SERVICE_ADDED = "onServiceAdded";

  @Input
  SubscribableChannel onServiceAdded();
}
