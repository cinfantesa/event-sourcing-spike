package edu.cinfantes.patient.domain;

import edu.cinfantes.patient.infrastructure.persistence.DomainEventDocument;

import java.util.List;
import java.util.stream.Stream;

public interface DomainEventRepository {
  void saveAll(List<DomainEvent> event);
  Stream<DomainEventDocument> findAllByAggregateIdAsc(String aggregateId);
}
