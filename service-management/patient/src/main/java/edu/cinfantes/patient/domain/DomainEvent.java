package edu.cinfantes.patient.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.joda.time.DateTime.now;

@Data
@NoArgsConstructor
public class DomainEvent {
  private UUID id;
  private DateTime when;
  private String aggregateId;
  private String type;
  private Map<String, Object> data;

  public DomainEvent(String aggregateId, String type, Map<String, Object> data) {
    id = randomUUID();
    when = now();

    this.data = Map.copyOf(data);
    this.aggregateId = aggregateId;
    this.type = type;
  }
}
