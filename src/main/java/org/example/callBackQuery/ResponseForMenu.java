package org.example.callBackQuery;

import org.example.Bot;
import org.example.Service;
import org.example.keyboardMarkup.Category;
import org.example.keyboardMarkup.Language;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

public class ResponseForMenu {
    Bot bot = new Bot();

    public void responseForCallBackQueryForMenu(Update update, Long chatId) {
        responseForCallBackQueryForAddSubscribe(update, chatId);
    }

    private void responseForCallBackQueryForAddSubscribe(Update update, Long chatId) {
        if (update.getMessage().getText().equals("/add")) {
             bot.sendMessage(chatId, "To create a subscription, select from the list: \n" +
                    Arrays.toString(Language.values()) + "\n" +
                    Arrays.toString(Category.values()));
        }
    }

    private void responseForCallBackQueryForDeleteSubscribe(Update update, Long chatId) {

    }
}
