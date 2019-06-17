package edu.cinfantes.patient.domain;

import java.util.List;

public interface PatientRepository {
  void saveAll(List<DomainEvent> event);
}
