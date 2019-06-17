package edu.cinfantes.patient.domain;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.joda.time.DateTime.now;

@Data
public class PatientCreatedDomainEvent implements DomainEvent{
  private UUID id;
  private DateTime when;
  private String aggregateId;

  private Map<String, Object> data;

  public PatientCreatedDomainEvent(String aggregateId, Map<String, Object> data) {
    id = randomUUID();
    when = now();

    this.data = Map.copyOf(data);
    this.aggregateId = aggregateId;
  }

  @Override
  public UUID id() {
    return this.id;
  }

  @Override
  public DateTime when() {
    return when;
  }

  @Override
  public String aggregateId() {
    return aggregateId;
  }

  @Override
  public String type() {
    return "cinfantes.patient.1.event.patient.created";
  }

  @Override
  public Map<String, Object> data() {
    return data;
  }
}
