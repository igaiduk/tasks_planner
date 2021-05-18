package com.amazon.mentorship.entities;

public enum Priority {
    PRIORITY_1("Priority 1"),
    PRIORITY_2("Priority 2"),
    PRIORITY_3("Priority 3"),
    PRIORITY_4("Priority 4");

    private String displayName;

    Priority(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    @Override public String toString() {
        return displayName;
    }
}
