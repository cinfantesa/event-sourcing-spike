package edu.cinfantes.service.application;


import edu.cinfantes.service.domain.PatientAddressId;
import edu.cinfantes.shared.domain.patient.PatientId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatePatientAddressTest {
  @Autowired
  private CreatePatientAddress createPatientAddress;

  @Test
  public void should_load_aggregate() {
    PatientAddressId id = new PatientAddressId();
    PatientId patientId = new PatientId("b70b17d7-c96c-49b1-9662-7fba666a1902");
    createPatientAddress.invoke(id, patientId, "Calle Alonso Cano 64", "Alicante");
  }
}