package org.example.callBackQuery;

import org.example.Bot;
import org.example.keyboardMarkup.Level;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ResponseForDeveloper {
    Bot bot = new Bot();

    public void responseForCallBackQueryForLanguage(Update update, Long chatId) {
        responseForCallBackQueryForJava(update, chatId);
        responseForCallBackQueryForPython(update, chatId);
        responseForCallBackQueryForNet(update, chatId);
        responseForCallBackQueryForC(update, chatId);
        responseForCallBackQueryForDevops(update, chatId);
    }

    private void responseForCallBackQueryForPython(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "Python");
    }

    private void responseForCallBackQueryForJava(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "Java");
    }

    private void responseForCallBackQueryForNet(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, ".NET");
    }

    private void responseForCallBackQueryForC(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "C%2B%2B");
    }

    private void responseForCallBackQueryForDevops(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "DevOps");
    }

    private void responseForCallBackQuery(Update update, Long chatId, String language) {
        for (Level level : Level.values()) {
            if (update.getCallbackQuery().getData().equals(language)) {
                bot.sendMessageWithDifferentLevelsForLanguage(chatId, language);
                break;
            } else if (update.getCallbackQuery().getData().equals(level.getLevel() + " " + language)) {
                bot.sendMessageWithActualVacancies(chatId, language, level.getLevel(), level.getLevel() + " " + language);
                break;
            } else if (level.getLevel().equals("Lead") && update.getCallbackQuery().getData().equals(language + " Team Lead")) {
                bot.sendMessageWithActualVacancies(chatId, language, level.getLevel(), language + " Team Lead");
                break;
            }
        }
    }
}
