package edu.cinfantes.service.infrastructure.persistence;

import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.DomainEventData;
import edu.cinfantes.shared.domain.DomainEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class ServiceDomainEventMongoRepository implements DomainEventRepository {
  private final SpringServiceDomainEventMongoRepository springServiceDomainEventMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    List<ServiceDomainEventDocument> documents = events.stream()
      .map(this::domainEventToDocument)
      .collect(Collectors.toList());

    springServiceDomainEventMongoRepository.saveAll(documents);
  }

  @Override
  public Stream<DomainEvent> findAllByAggregateIdAsc(String aggregateId) {
    return springServiceDomainEventMongoRepository.findAllByAggregateId(aggregateId, Sort.by(Sort.Direction.ASC, "data.attributes.occurredOn"))
      .map(this::documentToDomainEvent);
  }

  private DomainEvent documentToDomainEvent(ServiceDomainEventDocument document) {
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

  private ServiceDomainEventDocument domainEventToDocument(DomainEvent event) {
    return new ServiceDomainEventDocument(ServiceDomainEventDataDocument.builder()
      .id(event.getId())
      .type(event.getType())
      .occurredOn(event.getOccurredOn())
      .attributes(event.getAttributes())
      .build());
  }
}
