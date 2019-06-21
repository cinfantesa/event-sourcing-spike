package edu.cinfantes.patient.domain;

import edu.cinfantes.shared.domain.patient.PatientId;
import edu.cinfantes.shared.domain.service.ServiceId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
public class Service {
  private ServiceId id;
  private PatientId patientId;

  private String state;
  private DateTime date;
}
