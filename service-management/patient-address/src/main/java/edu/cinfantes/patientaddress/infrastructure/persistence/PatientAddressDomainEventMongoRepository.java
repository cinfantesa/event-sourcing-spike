package edu.cinfantes.patientaddress.infrastructure.persistence;

import edu.cinfantes.patientaddress.domain.DomainEvent;
import edu.cinfantes.patientaddress.domain.DomainEventRepository;
import edu.cinfantes.patientaddress.domain.PatientAddressDomainEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.UUID.fromString;

@Component
@AllArgsConstructor
public class PatientAddressDomainEventMongoRepository implements DomainEventRepository {
  private final SpringPatientAddressDomainEventMongoRepository springPatientAddressDomainEventMongoRepository;

  @Override
  public void saveAll(List<DomainEvent> events) {
    // TODO: traducir a JSON API
    List<PatientAddressDomainEventDocument> documents = events.stream()
      .map(event ->
        PatientAddressDomainEventDocument.builder()
          .id(event.getId().toString())
          .aggregateId(event.getAggregateId())
          .className(event.getClass().getCanonicalName())
          .type(event.getType())
          .when(event.getWhen())
          .data(event.getData())
          .build()
      )
      .collect(Collectors.toList());

    springPatientAddressDomainEventMongoRepository.saveAll(documents);
  }

  @Override
  public Stream<DomainEvent> findAllByAggregateIdAsc(String aggregateId) {
    return springPatientAddressDomainEventMongoRepository.findAllByAggregateIdOrderByWhenAsc(aggregateId)
      .map(this::documentToDomainEvent);
  }

  private DomainEvent documentToDomainEvent(PatientAddressDomainEventDocument document) {
    try {
      PatientAddressDomainEvent event = (PatientAddressDomainEvent) Class.forName(document.getClassName()).getDeclaredConstructor().newInstance();
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
