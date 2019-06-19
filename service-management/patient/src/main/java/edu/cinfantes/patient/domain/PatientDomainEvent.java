package edu.cinfantes.patient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.joda.time.DateTime.now;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PatientDomainEvent<T> implements DomainEvent<T> {
  protected UUID id;
  protected DateTime when;
  protected String aggregateId;
  protected String type;
  protected T data;

  public PatientDomainEvent(String aggregateId, T data) {
    id = randomUUID();
    when = now();

    this.aggregateId = aggregateId;
    this.data = data;
  }
}
