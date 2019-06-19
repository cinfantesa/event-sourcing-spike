package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.patient.domain.event.DomainEvent;
import edu.cinfantes.patient.domain.event.DomainEventRepository;
import edu.cinfantes.patient.domain.event.DomainEventData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
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
    List<PatientDomainEventDocument> documents = events.stream()
      .map(this::domainEventToDocument)
      .collect(Collectors.toList());

    springDomainEventMongoRepository.saveAll(documents);
  }

  @Override
  public Stream<DomainEvent> findAllByAggregateIdAsc(String aggregateId) {
    return springDomainEventMongoRepository.findAllByAggregateId(aggregateId, Sort.by(Sort.Direction.ASC, "data.attributes.occurredOn"))
      .map(this::documentToDomainEvent);
  }

  private DomainEvent documentToDomainEvent(PatientDomainEventDocument document) {
    DomainEventData domainEventData = DomainEventData.builder()
      .id(document.getData().getId())
      .type(document.getData().getType())
      .occurredOn(document.getData().getOccurredOn())
      .attributes(document.getData().getAttributes())
      .build();

    DomainEvent domainEvent = DomainEvent.builder()
      .data(domainEventData)
      .build();

    return domainEvent;
  }

  private PatientDomainEventDocument domainEventToDocument(DomainEvent event) {
    return new PatientDomainEventDocument(PatientDomainEventDataDocument.builder()
      .id(event.getId())
      .type(event.getType())
      .occurredOn(event.getOccurredOn())
      .attributes(event.getAttributes())
      .build());
  }
}
