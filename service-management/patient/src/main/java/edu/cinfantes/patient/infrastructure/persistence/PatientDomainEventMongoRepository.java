package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.DomainEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class PatientDomainEventMongoRepository implements DomainEventRepository {
  private final SpringPatientDomainEventMongoRepository springPatientDomainEventMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    List<PatientDomainEventDocument> documents = events.stream()
      .map(event ->
        PatientDomainEventDocument.builder()
          .id(event.getId().toString())
          .aggregateId(event.getAggregateId())
          .when(event.getWhen())
          .data(event.getData())
          .build()
      )
      .collect(Collectors.toList());

    springPatientDomainEventMongoRepository.saveAll(documents);
  }

  @Override
  public Stream<DomainEvent> findAllByAggregateIdAsc(String aggregateId) {
    Stream<DomainEvent> stream = springPatientDomainEventMongoRepository.findAllByAggregateIdOrderByWhenAsc(aggregateId)
      .map(this::documentToDomainEvent);

    return stream;
  }

  private DomainEvent documentToDomainEvent(PatientDomainEventDocument document) {
    try {
      DomainEvent event = (DomainEvent) Class.forName(document.getClassName()).getDeclaredConstructor().newInstance();
      event.setId(UUID.fromString(document.getId()));
      event.setAggregateId(document.getAggregateId());
      event.setWhen(document.getWhen());
      event.setData(document.getData());
      return event;
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
