package org.example.keyboardMarkup;

public enum Level {
    INTERN ("Intern"),
    TRAINEE ("Trainee"),
    JUNIOR ("Junior"),
    MIDDLE ("Middle"),
    SENIOR ("Senior"),
    LEAD ("Lead");

    private String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
