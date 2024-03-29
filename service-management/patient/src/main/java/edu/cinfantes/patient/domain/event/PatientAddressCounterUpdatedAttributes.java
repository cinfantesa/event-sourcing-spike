package edu.cinfantes.patient.domain.event;

import edu.cinfantes.shared.domain.Identifiable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientAddressCounterUpdatedAttributes implements Identifiable {
  private String id;
}
