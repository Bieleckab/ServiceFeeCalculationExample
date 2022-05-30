package com.dgtfactory.dgtfactoryassignment.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FeeCalculation {
    @JsonProperty("FIXED")
    FIXED,
    @JsonProperty("MIXED")
    MIXED,
    @JsonProperty("GRATIS")
    GRATIS,
    @JsonProperty("TIME_RATE")
    TIME_RATE
}
