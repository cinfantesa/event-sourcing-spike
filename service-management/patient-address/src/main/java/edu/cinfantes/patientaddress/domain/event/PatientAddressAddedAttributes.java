package edu.cinfantes.patientaddress.domain.event;

import edu.cinfantes.shared.domain.Identifiable;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class PatientAddressAddedAttributes implements Identifiable {
  private String id;
  private String address;
  private String locality;
  private PatientId patientId;
}
