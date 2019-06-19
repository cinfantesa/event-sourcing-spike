package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.patient.domain.Identificable;
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
public class DomainEventDocument {
  private DomainEventDataDocument data;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class DomainEventDataDocument implements Identificable {
  String id;
  String type;
  DateTime occurredOn;
  Object attributes;
}
