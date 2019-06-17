package edu.cinfantes.patient.domain;

import org.joda.time.DateTime;

import java.util.Map;
import java.util.UUID;

public interface DomainEvent {
  UUID id();
  DateTime when();
  String aggregateId();
  String type();
  Map<String, Object> data();
}
