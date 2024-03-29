package org.example;

import org.example.keyboardMarkup.Language;
import org.example.webSite.WebSite;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTTP {
    public static StringBuilder allNewVacancies = new StringBuilder();
    public static Map<String, String> resultMap = new HashMap<>();

    public String getAllActualVacancies(String language, String level) {
        Document document;
        StringBuilder stringBuilder = new StringBuilder();

        for (WebSite site : WebSite.values()) {
            try {
                document = Jsoup.connect(site.getCorrectLinkForWebSite(site, language, level)).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Elements vacanciesListWithLinks = document.getElementsByClass(site.getClassName());
            stringBuilder.append(vacanciesListWithLinks.toString()
                            .replaceAll(site.getOldRegex(), site.getNewRegex())
                            .replaceAll("\">", "\n")
                            .replaceAll("</a>", "")
                            .replaceAll("</p>", ""))
                    .append("\n");
        }

        return stringBuilder.toString();
    }

    public String getOnlyNewVacanciesFromPreviousTime(StringBuilder stringBuilder) {
        String[] strings = stringBuilder.toString().split("\n");

        for (int i = 0; i < strings.length - 1; i += 2) {
            if (!resultMap.containsKey(strings[i])) {
                resultMap.put(strings[i], strings[i + 1]);
                allNewVacancies.append(strings[i]).append("\n").append(strings[i + 1]).append("\n");
            }
        }

        if (allNewVacancies.isEmpty())
            return "It's not a new vacancies for this moment, check the previous response for this request";

        return allNewVacancies.toString();
    }
}
