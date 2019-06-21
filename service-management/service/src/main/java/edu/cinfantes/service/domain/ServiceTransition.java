package edu.cinfantes.service.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceTransition {
  INACTIVATE("inactivate") {
    @Override
    public ServiceState nextState() {
      return ServiceState.INACTIVE;
    }
  },
  ACTIVATE("activate") {
    @Override
    public ServiceState nextState() {
      return ServiceState.ACTIVE;
    }
  },
  ADD_TO_ROUTE("addtoroute") {
    @Override
    public ServiceState nextState() {
      return ServiceState.PLANNED;
    }
  },
  REMOVE_FROM_ROUTE("removefromroute") {
    @Override
    public ServiceState nextState() {
      return ServiceState.ACTIVE;
    }
  },
  START("start") {
    @Override
    public ServiceState nextState() {
      return ServiceState.STARTED;
    }
  },
  ARRIVE("arrive") {
    @Override
    public ServiceState nextState() {
      return ServiceState.IN_SITU;
    }
  },
  DEPART("depart") {
    @Override
    public ServiceState nextState() {
      return ServiceState.DEPARTED;
    }
  },
  TRANSFER("transfer") {
    @Override
    public ServiceState nextState() {
      return ServiceState.TRANSFERRED;
    }
  },
  FINISH("finish") {
    @Override
    public ServiceState nextState() {
      return ServiceState.FINISHED;
    }
  },
  FORCE_FINISH("forcefinish") {
    @Override
    public ServiceState nextState() {
      return ServiceState.FINISHED;
    }
  },
  CANCEL("cancel") {
    @Override
    public ServiceState nextState() {
      return ServiceState.CANCELLED;
    }
  };

  private String code;

  @JsonCreator
  ServiceTransition(String code) {
    this.code = code;
  }

  @JsonValue
  public String code() {
    return code;
  }

  public abstract ServiceState nextState();
}
