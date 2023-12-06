package com.group7.airplanesystembackend.entity;

public enum CustomerStatus {
    GUEST("Guest"),
    MEMBER("Member");

    private final String displayName;

    CustomerStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
