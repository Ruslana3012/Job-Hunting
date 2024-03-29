package org.example.webSite;

public enum WebSite implements Site {
    DOU("https://jobs.dou.ua/vacancies/?category=%s&search=%s", //where category is Language and search is Level
            "vt",
            "<a class=\"vt\" href=\"",
            ""),
    DJINNI("https://djinni.co/jobs/?primary_keyword=%s&exp_rank=%s", //where primary_keyword is Language and exp_rank is level
            "h3 job-list-item__link",
            "<a class=\"h3 job-list-item__link\" href=\"",
            "https://djinni.co");

    private final String webSite;
    private String className;
    private String oldRegex;
    private String newRegex;

    WebSite(String webSite, String className, String oldRegex, String newRegex) {
        this.webSite = webSite;
        this.className = className;
        this.oldRegex = oldRegex;
        this.newRegex = newRegex;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getClassName() {
        return className;
    }

    public String getOldRegex() {
        return oldRegex;
    }

    public String getNewRegex() {
        return newRegex;
    }

    @Override
    public String getCorrectLinkForWebSite(WebSite webSite, String language, String level) {
        return String.format(webSite.getWebSite(), language, level);
    }
}
