package edu.cinfantes.patient.infrastructure.event;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.EventBus;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RabbitmqEventBus implements EventBus {
  private static final String EXCHANGE = "domain_events";
  private final RabbitTemplate rabbitTemplate;

  @Override
  public void publish(List<DomainEvent> domainEvents) {
    domainEvents.forEach(event -> rabbitTemplate.convertAndSend(EXCHANGE, event.type(), event));
  }
}