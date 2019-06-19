package edu.cinfantes.patient.infrastructure.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.stream.Stream;

public interface SpringDomainEventMongoRepository extends MongoRepository<DomainEventDocument, String> {
  @Query("{'data.attributes._id': ?0}")
  Stream<DomainEventDocument> findAllByAggregateId(String aggregateId, Sort sort);
}
