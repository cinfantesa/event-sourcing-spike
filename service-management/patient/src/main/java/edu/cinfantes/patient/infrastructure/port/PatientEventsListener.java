package edu.cinfantes.patient.infrastructure.port;

import edu.cinfantes.patient.domain.Patient;
import edu.cinfantes.patient.infrastructure.persistence.PatientDocument;
import edu.cinfantes.patient.infrastructure.persistence.PatientViewRepository;
import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.EventBus;
import edu.cinfantes.shared.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@EnableBinding(Sink.class)
@AllArgsConstructor
public class PatientEventsListener {
  private final EventBus eventBus;
  private final PatientViewRepository repository;

  @StreamListener(Sink.INPUT)
  public void processOrder(DomainEvent<OnlyId> event) {
    String aggregateId = event.getData().getAttributes().getId();

    Stream<DomainEvent> domainEventStream = eventBus.loadEventStream(aggregateId);

    Patient patient = new Patient(domainEventStream);
    PatientDocument document = new PatientDocument(patient);
    repository.save(document);
  }

}

@Data
@NoArgsConstructor
class OnlyId implements Identifiable {
  String id;
}
