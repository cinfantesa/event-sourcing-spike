package edu.cinfantes.service.domain;

import java.util.Arrays;
import java.util.List;

public enum ServiceState {
  INACTIVE {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.ACTIVATE.equals(transition)
        || ServiceTransition.CANCEL.equals(transition);
    }
  },
  ACTIVE {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.ADD_TO_ROUTE.equals(transition)
        || ServiceTransition.CANCEL.equals(transition)
        || ServiceTransition.INACTIVATE.equals(transition);
    }
  },
  PLANNED {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.ADD_TO_ROUTE.equals(transition)
        || ServiceTransition.REMOVE_FROM_ROUTE.equals(transition)
        || ServiceTransition.START.equals(transition);
    }
  },
  STARTED {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.ARRIVE.equals(transition)
        || ServiceTransition.FINISH.equals(transition)
        || ServiceTransition.REMOVE_FROM_ROUTE.equals(transition);
    }
  },
  IN_SITU {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.DEPART.equals(transition)
        || ServiceTransition.FINISH.equals(transition)
        || ServiceTransition.REMOVE_FROM_ROUTE.equals(transition);
    }
  },
  DEPARTED {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.TRANSFER.equals(transition);
    }
  },
  TRANSFERRED {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.FINISH.equals(transition);
    }
  },
  FINISHED {
    @Override
    public Boolean can(ServiceTransition transition) {
      return false;
    }
  },
  CANCELLED {
    @Override
    public Boolean can(ServiceTransition transition) {
      return ServiceTransition.INACTIVATE.equals(transition)
        || ServiceTransition.ACTIVATE.equals(transition)
        || ServiceTransition.CANCEL.equals(transition);
    }
  };

  public abstract Boolean can(ServiceTransition transition);

  public static final List<ServiceState> IN_PROGRESS = Arrays.asList(
    PLANNED,
    STARTED,
    IN_SITU,
    DEPARTED,
    TRANSFERRED
  );

  public static final List<ServiceState> HAS_STARTED = Arrays.asList(
    STARTED,
    IN_SITU,
    DEPARTED,
    TRANSFERRED,
    FINISHED
  );

  public class Constants {
    public static final String STARTED = "STARTED";
    public static final String IN_SITU = "IN_SITU";
    public static final String DEPARTED = "DEPARTED";
    public static final String TRANSFERRED = "TRANSFERRED";
    public static final String FINISHED = "FINISHED";
  }
}
