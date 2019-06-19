package edu.cinfantes.patient.application;

import edu.cinfantes.patient.domain.PatientId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateNumberOfAddressesTest {
  @Autowired
  private UpdateNumberOfAddresses updateNumberOfAddresses;

  @Test
  public void should_update_address_counter() {
    PatientId patientId = new PatientId("6cc46b68-98a1-4f23-abb0-642d6d55e39b");

    updateNumberOfAddresses.invoke(patientId);
  }
}