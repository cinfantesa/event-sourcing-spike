package edu.cinfantes.patient.application;

import edu.cinfantes.shared.domain.patient.PatientId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientExitusTest {
  @Autowired
  private PatientExitus patientExitus;

  @Test
  public void should_update_leaving_date_and_emit_cancel_related_services() {
    PatientId patientId = new PatientId("a0784f62-e849-4883-8200-a8e3da750ce3");

    patientExitus.invoke(patientId);
  }
}