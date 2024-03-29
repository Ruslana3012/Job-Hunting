package org.example.keyboardMarkup;

public enum Language {
    JAVA ("Java"),
    PYTHON ("Python"),
    NET (".NET"),
    C ("C/C++"),
    DEVOPS ("DevOps");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

//    public String getAllLanguagesAsListOfPositionsWithLevels() {
////        StringBuilder builder = new StringBuilder();
////        for (Language lang : Language.values()) {
////            builder.append(lang + " Developer \n");
////        }
////        return builder.toString();
//    }
}
