package edu.cinfantes.patientaddress.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface SpringPatientAddressDomainEventMongoRepository extends MongoRepository<PatientAddressDomainEventDocument, String> {
  Stream<PatientAddressDomainEventDocument> findAllByAggregateIdOrderByWhenAsc(String aggregateId);
}
