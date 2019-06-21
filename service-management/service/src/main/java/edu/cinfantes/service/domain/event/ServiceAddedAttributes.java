package edu.cinfantes.service.domain.event;

import edu.cinfantes.service.domain.ServiceState;
import edu.cinfantes.shared.domain.Identifiable;
import edu.cinfantes.shared.domain.patient.PatientId;
import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@Builder
public final class ServiceAddedAttributes implements Identifiable {
  private String id;
  private ServiceState state;
  private DateTime date;
  private PatientId patientId;
}
