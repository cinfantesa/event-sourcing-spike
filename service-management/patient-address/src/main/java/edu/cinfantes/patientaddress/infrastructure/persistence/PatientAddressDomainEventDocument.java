package edu.cinfantes.patientaddress.infrastructure.persistence;

import lombok.Builder;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "PatientAddressEvents")
public class PatientAddressDomainEventDocument {
  @Id
  private String id;
  private DateTime when;
  private String aggregateId;
  private String className;
  private String type;

  private Object data;
}
