package com.grupoasv.patient.application;

import com.grupoasv.patient.domain.Patient;
import com.grupoasv.patient.domain.PatientComment;
import com.grupoasv.patient.domain.PatientId;
import com.grupoasv.patient.domain.PatientPersonalInfo;
import com.grupoasv.patient.domain.PatientRepository;
import com.grupoasv.patient.domain.PatientSip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class CreatePatient {
  private final PatientRepository repository;

  public void invoke(PatientId id, PatientSip sip, PatientPersonalInfo personalInfo, PatientComment comment) {
    Patient patient = new Patient(id, sip, personalInfo, comment);

    repository.save(patient);
  }
}
