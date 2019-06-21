package edu.cinfantes.service.infrastructure.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface SpringServiceDomainEventMongoRepository extends MongoRepository<ServiceDomainEventDocument, String> {
  @Query("{'data.attributes._id': ?0}")
  Stream<ServiceDomainEventDocument> findAllByAggregateId(String aggregateId, Sort sort);

  @Query("{'data.attributes.patientId.value': ?0}")
  Stream<ServiceDomainEventDocument> findAllByPatientId(String patientId);
}
