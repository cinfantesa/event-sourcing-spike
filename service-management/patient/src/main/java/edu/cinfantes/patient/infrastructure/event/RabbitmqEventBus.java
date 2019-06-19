package edu.cinfantes.patient.infrastructure.event;

import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.DomainEventRepository;
import edu.cinfantes.shared.domain.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
@EnableBinding(Source.class)
public class RabbitmqEventBus implements EventBus {
  private final DomainEventRepository repository;
  private final Source source;

  @Override
  public void appendToEventStream(List<DomainEvent> domainEvents) {
    repository.saveAll(domainEvents);
    domainEvents.forEach(event -> source.output().send(MessageBuilder.withPayload(event).build()));
  }

  @Override
  public Stream<DomainEvent> loadEventStream(String aggregateId) {
    return repository.findAllByAggregateIdAsc(aggregateId);
  }
}
