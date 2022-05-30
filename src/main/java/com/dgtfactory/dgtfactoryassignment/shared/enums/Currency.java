package com.dgtfactory.dgtfactoryassignment.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Currency {
    @JsonProperty("EUR")
    EUR,
    @JsonProperty("USD")
    USD,
    @JsonProperty("CZK")
    CZK;
}
