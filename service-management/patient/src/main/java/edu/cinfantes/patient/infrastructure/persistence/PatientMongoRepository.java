package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PatientMongoRepository implements PatientRepository {
  private final SpringPatientMongoRepository springPatientMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    List<PatientDomainEventDocument> documents = events.stream()
      .map(event ->
        PatientDomainEventDocument.builder()
          .id(event.id().toString())
          .aggregateId(event.aggregateId())
          .when(event.when())
          .data(event.data())
          .build()
      )
      .collect(Collectors.toList());

    springPatientMongoRepository.saveAll(documents);
  }
}
