package edu.cinfantes.patient.application;

import edu.cinfantes.shared.domain.patient.PatientId;
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
    PatientId patientId = new PatientId("9340cffd-5a61-4acd-ab4b-4ca654a767b6");

    updateNumberOfAddresses.invoke(patientId);
  }
}