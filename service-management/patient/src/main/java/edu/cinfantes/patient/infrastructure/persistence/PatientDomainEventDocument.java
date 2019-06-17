package edu.cinfantes.patient.infrastructure.persistence;

import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Builder
@Document(collection = "PatientEvents")
public class PatientDomainEventDocument{
  @Id
  private String id;
  private DateTime when;
  private String aggregateId;

  private Map<String, Object> data;
}
