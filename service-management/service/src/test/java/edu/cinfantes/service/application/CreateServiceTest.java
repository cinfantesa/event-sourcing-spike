package edu.cinfantes.service.application;


import edu.cinfantes.shared.domain.patient.PatientId;
import edu.cinfantes.shared.domain.service.ServiceId;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateServiceTest {
  @Autowired
  private CreateService createService;

  @Test
  public void should_load_aggregate() {
    ServiceId id = new ServiceId();
    PatientId patientId = new PatientId("a0784f62-e849-4883-8200-a8e3da750ce3");

      createService.invoke(id, patientId, "ACTIVE", DateTime.now());
  }
}