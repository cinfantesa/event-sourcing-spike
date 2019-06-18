package edu.cinfantes.patientaddress.infrastructure.event;

import edu.cinfantes.patientaddress.domain.DomainEvent;
import edu.cinfantes.patientaddress.domain.DomainEventRepository;
import edu.cinfantes.patientaddress.domain.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class RabbitmqEventBus implements EventBus {
  private static final String EXCHANGE = "patient_address_domain_events";

  private final DomainEventRepository repository;
  private final RabbitTemplate rabbitTemplate;

  @Override
  public void appendToEventStream(List<DomainEvent> domainEvents) {
    repository.saveAll(domainEvents);
    domainEvents.forEach(event -> rabbitTemplate.convertAndSend(EXCHANGE, event.getType(), event));
  }

  @Override
  public Stream<DomainEvent> loadEventStream(String aggregateId) {
    return repository.findAllByAggregateIdAsc(aggregateId);
  }
}
