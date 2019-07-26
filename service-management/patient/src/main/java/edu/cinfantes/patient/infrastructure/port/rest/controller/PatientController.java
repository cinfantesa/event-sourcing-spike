package edu.cinfantes.patient.infrastructure.port.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

  @PostMapping("/{id}")
  public String createPatient(@PathVariable("id") String id) {
    return null;
  }
}
