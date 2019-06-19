package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.shared.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "PatientEvents")
public class PatientDomainEventDocument {
  private PatientDomainEventDataDocument data;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PatientDomainEventDataDocument implements Identifiable {
  String id;
  String type;
  DateTime occurredOn;
  Object attributes;
}
