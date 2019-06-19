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
  private final SpringDomainEventMongoRepository springDomainEventMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    List<DomainEventDocument> documents = events.stream()
      .map(event -> new DomainEventDocument(event.getData()))
      .collect(Collectors.toList());

    springDomainEventMongoRepository.saveAll(documents);
  }

  @Override
  public Stream<DomainEvent> findAllByAggregateIdAsc(String aggregateId) {
    return springDomainEventMongoRepository.findAllByDataIdOrderByOccurredOnAsc(aggregateId)
      .map(document -> new DomainEvent(document.getData()));
  }
}
