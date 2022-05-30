package com.dgtfactory.dgtfactoryassignment.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionState {
    @JsonProperty("OPEN")
    OPEN,
    @JsonProperty("FINISHED")
    FINISHED;
}
