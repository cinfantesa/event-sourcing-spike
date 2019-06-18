package edu.cinfantes.patient.domain;

import org.joda.time.DateTime;

import java.util.UUID;

public interface DomainEvent<T> {
  UUID getId();
  DateTime getWhen();
  String getAggregateId();
  String getType();
  T getData();
}
