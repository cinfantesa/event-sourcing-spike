package edu.cinfantes.shared.domain;

import java.util.List;
import java.util.stream.Stream;

public interface EventBus {
  void appendToEventStream(List<DomainEvent> domainEvents);

  Stream<DomainEvent> loadEventStream(String aggregateId);
}
