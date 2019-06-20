package edu.cinfantes.patient.domain.event;

import edu.cinfantes.shared.domain.Identifiable;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientAddressAddedAttributes implements Identifiable {
  private String id;
  private PatientId patientId;
}
