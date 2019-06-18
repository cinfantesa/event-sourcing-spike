package edu.cinfantes.patientaddress.domain;

import java.util.List;
import java.util.stream.Stream;

public interface DomainEventRepository {
  void saveAll(List<DomainEvent> event);
  Stream<DomainEvent> findAllByAggregateIdAsc(String aggregateId);
}
