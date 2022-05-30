package com.dgtfactory.dgtfactoryassignment.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PriceRate {
    @JsonProperty("ONE_TIME")
    ONE_TIME,
    @JsonProperty("HOUR")
    HOUR,
    @JsonProperty("DAY")
    DAY,
    @JsonProperty("WEEK")
    WEEK,
    @JsonProperty("MONTH")
    MONTH,
    @JsonProperty("QUARTER")
    QUARTER,
    @JsonProperty("YEAR")
    YEAR;
}
