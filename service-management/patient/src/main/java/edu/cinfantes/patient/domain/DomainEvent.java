package edu.cinfantes.patient.domain;

import org.joda.time.DateTime;

import java.util.Map;
import java.util.UUID;

public interface DomainEvent {
  UUID getId();
  DateTime getWhen();
  String getAggregateId();
  String getType();
  Map<String, Object> getData();
}
