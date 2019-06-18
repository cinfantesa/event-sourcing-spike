package edu.cinfantes.patientaddress.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.joda.time.DateTime.now;

@Data
@NoArgsConstructor
public abstract class PatientAddressDomainEvent<T> implements DomainEvent<T> {
  protected UUID id;
  protected DateTime when;
  protected String aggregateId;
  protected String type;
  protected T data;

  public PatientAddressDomainEvent(String aggregateId, T data) {
    id = randomUUID();
    when = now();

    this.aggregateId = aggregateId;
    this.data = data;
  }
}
