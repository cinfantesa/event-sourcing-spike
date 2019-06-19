package edu.cinfantes.patient.domain;

import edu.cinfantes.shared.domain.DomainEvent;
import edu.cinfantes.shared.domain.Identifiable;
import lombok.Builder;
import lombok.Data;

public final class PatientAddressCounterUpdatedDomainEvent extends DomainEvent<PatientAddressCounterUpdatedAttributes> {
  public static final String TYPE = "cinfantes.patient.1.event.patient.addresses.counter.updated";

  public PatientAddressCounterUpdatedDomainEvent(PatientAddressCounterUpdatedAttributes data) {
    super(data, TYPE);
  }
}

@Data
@Builder
class PatientAddressCounterUpdatedAttributes implements Identifiable {
  private String id;
}