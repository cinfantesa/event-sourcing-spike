package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.DomainEventRepository;
import edu.cinfantes.patient.domain.PatientDomainEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.UUID.fromString;

@Component
@AllArgsConstructor
public class PatientDomainEventMongoRepository implements DomainEventRepository {
  private final SpringPatientDomainEventMongoRepository springPatientDomainEventMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    // TODO: traducir a JSON API
    List<PatientDomainEventDocument> documents = events.stream()
      .map(event ->
        PatientDomainEventDocument.builder()
          .id(event.getId().toString())
          .aggregateId(event.getAggregateId())
          .className(event.getClass().getCanonicalName())
          .type(event.getType())
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
      // TODO: mejorar
      PatientDomainEvent event = (PatientDomainEvent) Class.forName(document.getClassName()).getDeclaredConstructor().newInstance();
      event.setId(fromString(document.getId()));
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
