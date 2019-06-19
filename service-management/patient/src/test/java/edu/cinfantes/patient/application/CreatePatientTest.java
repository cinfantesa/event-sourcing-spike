package edu.cinfantes.patient.application;

import edu.cinfantes.patient.domain.PatientComment;
import edu.cinfantes.patient.domain.PatientPersonalInfo;
import edu.cinfantes.patient.domain.PatientSip;
import edu.cinfantes.shared.domain.patient.PatientId;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatePatientTest {
  @Autowired
  private CreatePatient createPatient;

  @Test
  public void should_create_patient() {
    PatientId patientId = new PatientId();
    PatientSip patientSip = new PatientSip(1234567);
    PatientPersonalInfo patientPersonalInfo = new PatientPersonalInfo("Cristobal", "Infantes", "Alvarez", DateTime.now().withDate(1980, 11, 11));
    PatientComment patientComment = new PatientComment("Comentario");

    createPatient.invoke(patientId, patientSip, patientPersonalInfo, patientComment);
  }
}