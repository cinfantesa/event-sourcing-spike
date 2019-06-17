package edu.cinfantes.patient.domain;

import java.util.List;

public interface EventBus {
  void publish(List<DomainEvent> domainEvents);

  void loadDomainEventsStream(String value);
}
