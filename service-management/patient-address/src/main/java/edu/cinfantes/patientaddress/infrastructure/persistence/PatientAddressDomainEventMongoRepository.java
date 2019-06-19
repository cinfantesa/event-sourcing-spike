package edu.cinfantes.patientaddress.infrastructure.persistence;

import edu.cinfantes.patientaddress.domain.DomainEvent;
import edu.cinfantes.patientaddress.domain.DomainEventData;
import edu.cinfantes.patientaddress.domain.DomainEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class PatientAddressDomainEventMongoRepository implements DomainEventRepository {
  private final SpringPatientAddressDomainEventMongoRepository springPatientAddressDomainEventMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    List<PatientAddressDomainEventDocument> documents = events.stream()
      .map(this::domainEventToDocument)
      .collect(Collectors.toList());

    springPatientAddressDomainEventMongoRepository.saveAll(documents);
  }

  @Override
  public Stream<DomainEvent> findAllByAggregateIdAsc(String aggregateId) {
    return springPatientAddressDomainEventMongoRepository.findAllByAggregateId(aggregateId, Sort.by(Sort.Direction.ASC, "data.attributes.occurredOn"))
      .map(this::documentToDomainEvent);
  }

  private DomainEvent documentToDomainEvent(PatientAddressDomainEventDocument document) {
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

  private PatientAddressDomainEventDocument domainEventToDocument(DomainEvent event) {
    return new PatientAddressDomainEventDocument(PatientAddressDomainEventDataDocument.builder()
      .id(event.getId())
      .type(event.getType())
      .occurredOn(event.getOccurredOn())
      .attributes(event.getAttributes())
      .build());
  }
}
