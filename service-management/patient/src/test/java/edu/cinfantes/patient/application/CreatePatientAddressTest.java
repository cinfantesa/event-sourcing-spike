package edu.cinfantes.patient.application;


import edu.cinfantes.patient.domain.PatientAddress;
import edu.cinfantes.patient.domain.PatientId;
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
    PatientId patientId = new PatientId("d21d63dd-8c67-4e89-acb6-9c86cc2d994e");
    PatientAddress address = new PatientAddress("Calle Alonso Cano 64","Alicante");

    createPatientAddress.invoke(patientId, address);
  }
}