package edu.cinfantes.patient.application;

import edu.cinfantes.patient.domain.DomainEvent;
import edu.cinfantes.patient.domain.Patient;
import edu.cinfantes.patient.domain.PatientComment;
import edu.cinfantes.patient.domain.PatientId;
import edu.cinfantes.patient.domain.PatientPersonalInfo;
import edu.cinfantes.patient.domain.PatientRepository;
import edu.cinfantes.patient.domain.PatientSip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public final class CreatePatient {
  private final PatientRepository repository;

  public void invoke(PatientId id, PatientSip sip, PatientPersonalInfo personalInfo, PatientComment comment) {
    Patient patient = new Patient(id, sip, personalInfo, comment);

    List<DomainEvent> domainEvents = patient.pullDomainEvents();
    repository.saveAll(domainEvents);
  }
}
