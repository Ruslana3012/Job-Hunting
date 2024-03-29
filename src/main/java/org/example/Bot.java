package org.example;

import org.example.callBackQuery.ResponseForCategory;
import org.example.callBackQuery.ResponseForDeveloper;
import org.example.callBackQuery.ResponseForMenu;
import org.example.keyboardMarkup.KeyboardCategories;
import org.example.keyboardMarkup.KeyboardLanguages;
import org.example.keyboardMarkup.KeyboardLevels;
import org.example.keyboardMarkup.KeyboardMarkup;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Timer;

public class Bot extends TelegramLongPollingBot {
    private Timer timer = new Timer();
    private BotTimerTask botTimerTask = new BotTimerTask();

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = new Service().getChatId(update);

        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            sendMessageWithDifferentCategories(chatId);
        } else if (update.hasCallbackQuery()) {
            new ResponseForDeveloper().responseForCallBackQueryForLanguage(update, chatId);
            new ResponseForCategory().responseForCallBackQueryForCategory(update, chatId);

        } else {
            new ResponseForMenu().responseForCallBackQueryForMenu(update, chatId);
        }
    }

    @Override
    public String getBotUsername() {
        return "JobHuntingITbot";
    }

    @Override
    public String getBotToken() {
        return "7065017042:AAEJg0LpJlZQs2ScM4zlkF1Yog-MMsozO9Y";
    }

    public void sendMessageWithDifferentCategories(Long chatId) {
        SendMessage categories = KeyboardCategories.sendInlineKeyBoardMessageForCategories(chatId);
        categories.setChatId(chatId);
        sendApiMethodAsync(categories);
    }

    public void sendMessageWithDifferentLanguages(Long chatId) {
        SendMessage languages = KeyboardLanguages.sendInlineKeyBoardMessageForLanguages(chatId);
        languages.setChatId(chatId);
        sendApiMethodAsync(languages);
    }

    public void sendMessageWithDifferentLevelsForLanguage(Long chatId, String language) {
        SendMessage levels = KeyboardLevels.sendInlineKeyBoardMessageForDeveloper(chatId, language);
        levels.setChatId(chatId);
        sendApiMethodAsync(levels);
    }

    public void sendMessageWithActualVacancies(Long chatId, String language, String level, String jobTitle) {
        SendMessage vacancies = KeyboardMarkup.sendFormatInlineKeyBoardResponseWithActualVacancies(
                chatId,
                new HTTP().getAllActualVacancies(language, level),
                jobTitle);
        vacancies.setChatId(chatId);
        sendApiMethodAsync(vacancies);
    }

    public void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage(chatId.toString(), text);
        sendApiMethodAsync(message);
    }
}
