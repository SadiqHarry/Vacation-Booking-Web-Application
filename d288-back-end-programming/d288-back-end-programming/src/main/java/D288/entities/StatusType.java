package D288.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusType {
    @JsonProperty("pending")
    PENDING("pending"),
    @JsonProperty("ordered")
    ORDERED("ordered"),
    @JsonProperty("canceled")
    CANCELED("canceled");

    private final String value;

    StatusType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

