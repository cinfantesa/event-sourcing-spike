package edu.cinfantes.patient.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.joda.time.DateTime.now;

@NoArgsConstructor
public abstract class PatientDomainEvent implements DomainEvent {
  @Getter @Setter
  private UUID id;
  @Getter @Setter
  private DateTime when;
  @Getter @Setter
  private String aggregateId;
  @Setter
  private String type;
  @Getter @Setter
  private Map<String, Object> data;

  public PatientDomainEvent(String aggregateId, String type, Map<String, Object> data) {
    id = randomUUID();
    when = now();

    this.data = Map.copyOf(data);
    this.aggregateId = aggregateId;
    this.type = type;
  }
}
