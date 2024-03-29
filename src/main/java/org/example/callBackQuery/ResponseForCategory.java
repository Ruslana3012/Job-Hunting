package org.example.callBackQuery;

import org.example.Bot;
import org.example.keyboardMarkup.Level;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ResponseForCategory {
    Bot bot = new Bot();

    public void responseForCallBackQueryForCategory(Update update, Long chatId) {
        responseForCallBackQueryForSoftwareDevelopment(update, chatId);
        responseForCallBackQueryForDataScience(update, chatId);
        responseForCallBackQueryForBusinessAnalysis(update, chatId);
        responseForCallBackQueryForDataAnalysis(update, chatId);
        responseForCallBackQueryForProjectManagement(update, chatId);
    }

    private void responseForCallBackQueryForSoftwareDevelopment(Update update, Long chatId) {
        if (update.getCallbackQuery().getData().equals("Software Development")) {
            bot.sendMessageWithDifferentLanguages(chatId);
        }
    }

    private void responseForCallBackQueryForDataScience(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "Data Science");
    }

    private void responseForCallBackQueryForBusinessAnalysis(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "Business Analyst");
    }

    private void responseForCallBackQueryForDataAnalysis(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "Data Analyst");
    }

    private void responseForCallBackQueryForProjectManagement(Update update, Long chatId) {
        responseForCallBackQuery(update, chatId, "Project Manager");
    }

    private void responseForCallBackQuery(Update update, Long chatId, String category) {
        if (update.getCallbackQuery().getData().equals(category)) {
            bot.sendMessageWithDifferentLevelsForLanguage(chatId, category);
        } else if (update.getCallbackQuery().getData().equals(Level.INTERN.getLevel() + " " + category)) {
            bot.sendMessageWithActualVacancies(chatId, category, Level.INTERN.getLevel(), Level.INTERN.getLevel() + " " + category);
        } else if (update.getCallbackQuery().getData().equals(Level.TRAINEE.getLevel() + " " + category)) {
            bot.sendMessageWithActualVacancies(chatId, category, Level.TRAINEE.getLevel(), Level.TRAINEE.getLevel() + " " + category);
        } else if (update.getCallbackQuery().getData().equals(Level.MIDDLE.getLevel() + " " + category)) {
            bot.sendMessageWithActualVacancies(chatId, category, Level.MIDDLE.getLevel(), Level.MIDDLE.getLevel() + " " + category);
        } else if (update.getCallbackQuery().getData().equals(Level.SENIOR.getLevel() + " " + category)) {
            bot.sendMessageWithActualVacancies(chatId, category, Level.SENIOR.getLevel(), Level.SENIOR.getLevel() + " " + category);
        } else if (update.getCallbackQuery().getData().equals(category + " Team Lead")) {
            bot.sendMessageWithActualVacancies(chatId, category, Level.LEAD.getLevel(), category + " Team Lead");
        }
    }
}
