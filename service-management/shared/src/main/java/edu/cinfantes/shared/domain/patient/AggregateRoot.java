package edu.cinfantes.shared.domain.patient;

import edu.cinfantes.shared.domain.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot {
  private List<DomainEvent> events = new ArrayList<>();

  public List<DomainEvent> pullDomainEvents() {
    List<DomainEvent> allDomainEvents = List.copyOf(events);
    events.clear();

    return allDomainEvents;
  }

  protected void addDomainEvent(DomainEvent event) {
    events.add(event);
  }
}
