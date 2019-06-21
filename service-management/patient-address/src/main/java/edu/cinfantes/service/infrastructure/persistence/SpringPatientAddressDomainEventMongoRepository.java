package edu.cinfantes.service.infrastructure.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface SpringPatientAddressDomainEventMongoRepository extends MongoRepository<PatientAddressDomainEventDocument, String> {
  @Query("{'data.attributes._id': ?0}")
  Stream<PatientAddressDomainEventDocument> findAllByAggregateId(String aggregateId, Sort sort);
}
