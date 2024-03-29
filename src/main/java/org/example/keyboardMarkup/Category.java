package org.example.keyboardMarkup;

public enum Category {
    SOFTWARE_DEVELOPMENT ("Software Development"),
    DATA_SCIENCE ("Data Science"),
    BUSINESS_ANALYST("Business Analyst"),
    DATA_ANALYST("Data Analyst"),
    PROJECT_MANAGEMENT("Project Manager");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
