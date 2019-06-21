package edu.cinfantes.service.application;

import edu.cinfantes.service.domain.Service;
import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.EventBus;
import edu.cinfantes.shared.domain.patient.PatientId;
import edu.cinfantes.shared.domain.service.ServiceId;
import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public final class CreateService {
  private final EventBus eventBus;

  public void invoke(ServiceId id, PatientId patientId, String state, DateTime date) {
    Service service = new Service(id, patientId, state, date);

    List<DomainEvent> domainEvents = service.pullDomainEvents();
    eventBus.appendToEventStream(domainEvents);
  }
}
