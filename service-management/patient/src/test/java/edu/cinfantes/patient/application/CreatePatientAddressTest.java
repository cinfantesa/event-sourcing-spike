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
    PatientId patientId = new PatientId("0e57091c-6e31-4eb5-8732-52952e1f85a5");
    PatientAddress address = new PatientAddress("Calle Alonso Cano 64","Alicante");

    createPatientAddress.invoke(patientId, address);
  }
}