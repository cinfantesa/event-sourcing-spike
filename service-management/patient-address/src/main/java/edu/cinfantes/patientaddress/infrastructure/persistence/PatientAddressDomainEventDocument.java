package edu.cinfantes.patientaddress.infrastructure.persistence;

import edu.cinfantes.patientaddress.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "PatientAddressEvents")
public class PatientAddressDomainEventDocument {
  private PatientAddressDomainEventDataDocument data;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PatientAddressDomainEventDataDocument implements Identifiable {
  String id;
  String type;
  DateTime occurredOn;
  Object attributes;
}
