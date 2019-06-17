package edu.cinfantes.patient.domain;

import lombok.Getter;

@Getter
public final class PatientSip {
  private static final double MAX_LENGTH = 8d;

  private Integer sip;

  public PatientSip(Integer sip) {
    ensureSipIsPositive(sip);
    ensureSipMaxLength(sip);

    this.sip = sip;
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
