package com.amazon.mentorship.entities;

public enum Status {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    @Override public String toString() {
        return displayName;
    }
}
