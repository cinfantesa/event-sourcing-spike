package edu.cinfantes.patient.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface SpringDomainEventMongoRepository extends MongoRepository<DomainEventDocument, String> {
  Stream<DomainEventDocument> findAllByDataIdOrderByOccurredOnAsc(String aggregateId);
}
