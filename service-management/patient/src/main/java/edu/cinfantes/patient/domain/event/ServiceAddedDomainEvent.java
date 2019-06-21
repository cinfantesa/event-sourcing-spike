package edu.cinfantes.patient.domain.event;

import edu.cinfantes.shared.domain.DomainEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ServiceAddedDomainEvent extends DomainEvent<ServiceAddedAttributes> {
  public static final String TYPE = "cinfantes.service.1.event.service.added";

  public ServiceAddedDomainEvent(ServiceAddedAttributes data) {
    super(data, TYPE);
  }
}

