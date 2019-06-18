package edu.cinfantes.patient.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PatientAddressAddedDomainEvent extends PatientDomainEvent<PatientAddressAddedPayload> {

  public PatientAddressAddedDomainEvent(String aggregateId, PatientAddressAddedPayload data) {
    super(aggregateId, data);

    type = "cinfantes.patient.1.event.patient.address.added";
  }
}

@Data
@Builder
class PatientAddressAddedPayload {
  private String address;
  private String locality;
}
