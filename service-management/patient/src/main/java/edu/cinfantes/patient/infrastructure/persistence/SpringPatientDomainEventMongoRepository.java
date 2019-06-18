package edu.cinfantes.patient.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface SpringPatientDomainEventMongoRepository extends MongoRepository<PatientDomainEventDocument, String> {
  Stream<PatientDomainEventDocument> findAllByAggregateIdOrderByWhenAsc(String aggregateId);
}
