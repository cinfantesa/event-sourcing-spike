package edu.cinfantes.patient.infrastructure.port;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class PatientAddressAddedListener {
  @RabbitListener(queues = "patient.update.number.services")
  public void processOrder(Message data) {
    System.out.println(data);
  }

}
