package edu.cinfantes.patient.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringPatientMongoRepository extends MongoRepository<PatientDomainEventDocument, String> {
}
