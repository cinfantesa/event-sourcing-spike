package edu.cinfantes.patient.infrastructure.persistence;

import edu.cinfantes.patient.domain.Patient;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PatientView")
@Data
@NoArgsConstructor
public final class PatientDocument {
  private PatientIdDocument id;
  private PatientSipDocument sip;
  private PatientPersonalInfoDocument personalInfo;
  private PatientCommentDocument comment;
  private int numberOfAddresses;

  public PatientDocument(Patient patient) {
    id = PatientIdDocument.builder().value(patient.getId().getValue()).build();
    sip = PatientSipDocument.builder().value(patient.getSip().getValue()).build();
    personalInfo = PatientPersonalInfoDocument.builder()
      .name(patient.getPersonalInfo().getName())
      .firstSurname(patient.getPersonalInfo().getFirstSurname())
      .secondSurname(patient.getPersonalInfo().getSecondSurname())
      .birthDate(patient.getPersonalInfo().getBirthDate())
      .build();
    comment = PatientCommentDocument.builder().value(patient.getComment().getValue()).build();
    numberOfAddresses = patient.getNumberOfAddresses();
  }
}

@Data
@Builder
class PatientIdDocument {
  String value;
}

@Data
@Builder
class PatientSipDocument {
  Integer value;
}

@Data
@Builder
class PatientCommentDocument {
  String value;
}

@Data
@Builder
class PatientPersonalInfoDocument {
  String name;
  String firstSurname;
  String secondSurname;
  DateTime birthDate;
}