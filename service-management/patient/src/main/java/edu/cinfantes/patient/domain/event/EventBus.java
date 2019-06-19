package edu.cinfantes.patient.domain.event;

import java.util.List;
import java.util.stream.Stream;

public interface EventBus {
  void appendToEventStream(List<DomainEvent> domainEvents);

  Stream<DomainEvent> loadEventStream(String aggregateId);
}
