package edu.cinfantes.patient.domain;

import lombok.Getter;

@Getter
public final class PatientSip {
  private static final double MAX_LENGTH = 8d;

  private Integer value;

  public PatientSip(Integer value) {
    ensureSipIsPositive(value);
    ensureSipMaxLength(value);

    this.value = value;
  }

  public static PatientSip copyOf(PatientSip patientSip) {
    return new PatientSip(patientSip.getValue());
  }

  private void ensureSipIsPositive(Integer sip) {
    if (sip < 0) {
      throw new SipNotPositiveException();
    }
  }

  private void ensureSipMaxLength(Integer sip) {
    double length = sip != 0 ? Math.log10(sip) + 1 : 0;

    if (length > MAX_LENGTH) {
      throw new SipMaxLengthException();
    }
  }
}
