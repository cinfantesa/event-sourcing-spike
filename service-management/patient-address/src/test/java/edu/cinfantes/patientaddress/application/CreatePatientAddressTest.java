package edu.cinfantes.patientaddress.application;


import edu.cinfantes.patientaddress.domain.PatientAddressId;
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
    PatientId patientId = new PatientId("46fe0c0a-888d-42cd-8008-e3ab81b70ccf");
    createPatientAddress.invoke(id, patientId, "Calle Alonso Cano 64", "Alicante");
  }
}