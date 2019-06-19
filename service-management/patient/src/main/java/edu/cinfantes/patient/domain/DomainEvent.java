package edu.cinfantes.patient.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import static java.util.UUID.randomUUID;
import static org.joda.time.DateTime.now;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DomainEvent<T extends Identificable> {
  protected EventData<T> data;

  public DomainEvent(T data, String type) {
    this.data = new EventData<>();
    this.data.id = randomUUID().toString();
    this.data.type = type;
    this.data.occurredOn = now();
    this.data.attributes = data;
  }

  public String getId() {
    return data.id;
  }

  public String getType() {
    return data.type;
  }

  public DateTime getOccurredOn() {
    return data.occurredOn;
  }

  public T getAttributes() {
    return data.attributes;
  }
}

class EventData<T> {
  String id;
  String type;
  DateTime occurredOn;
  T attributes;
//  R meta;

}
