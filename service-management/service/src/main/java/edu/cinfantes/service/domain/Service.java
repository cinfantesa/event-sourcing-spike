package edu.cinfantes.service.domain;

import edu.cinfantes.service.domain.event.ServiceAddedAttributes;
import edu.cinfantes.service.domain.event.ServiceAddedDomainEvent;
import edu.cinfantes.shared.domain.patient.AggregateRoot;
import edu.cinfantes.shared.domain.patient.PatientId;
import edu.cinfantes.shared.domain.service.ServiceId;
import lombok.Getter;
import org.joda.time.DateTime;

import static java.util.Objects.requireNonNull;

@Getter
public class Service extends AggregateRoot {
  private ServiceId id;
  private PatientId patientId;

  private String state;
  private DateTime date;

  public Service(ServiceId id, PatientId patientId, String state, DateTime date) {
    requireNonNull(state);
    requireNonNull(date);


    this.id = id;
    this.state = state;
    this.date = date;
    this.patientId = patientId;

    addDomainEvent(new ServiceAddedDomainEvent(ServiceAddedAttributes.builder()
      .id(id.getValue())
      .state(state)
      .date(date)
      .patientId(patientId)
      .build()));
  }
}
