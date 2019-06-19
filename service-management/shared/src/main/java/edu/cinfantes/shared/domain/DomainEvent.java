package edu.cinfantes.shared.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import static java.util.UUID.randomUUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainEvent<T extends Identifiable> {
  protected DomainEventData<T> data;

  public DomainEvent(T attributes, String type) {
    this.data = new DomainEventData<>();
    this.data.id = randomUUID().toString();
    this.data.type = type;
    this.data.occurredOn = DateTime.now();
    this.data.attributes = attributes;
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

