package edu.cinfantes.patientaddress.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainEventData<T> {
  String id;
  String type;
  DateTime occurredOn;
  T attributes;
//  R meta;
}
