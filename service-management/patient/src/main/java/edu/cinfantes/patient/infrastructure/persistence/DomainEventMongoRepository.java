package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.DomainEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class DomainEventMongoRepository implements DomainEventRepository {
  private final SpringPatientMongoRepository springPatientMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    List<DomainEventDocument> documents = events.stream()
      .map(event ->
        DomainEventDocument.builder()
          .id(event.id().toString())
          .aggregateId(event.aggregateId())
          .when(event.when())
          .data(event.data())
          .build()
      )
      .collect(Collectors.toList());

    springPatientMongoRepository.saveAll(documents);
  }

  @Override
  public Stream<DomainEventDocument> findAllByAggregateIdAsc(String aggregateId) {
//    return springPatientMongoRepository.findAllByAggregateIdAsc(aggregateId)
//      .map(document -> Doma)
    return Stream.empty();
  }
}
