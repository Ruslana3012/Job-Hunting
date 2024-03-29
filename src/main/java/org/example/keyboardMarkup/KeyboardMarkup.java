package org.example.keyboardMarkup;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardMarkup {
    public static SendMessage sendFormatInlineKeyBoardResponseWithActualVacancies(Long chatId, String vacancies, String jobTitle) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        String[] vacancy = vacancies.split("\n");

        for (int i = 0; i < vacancy.length - 1; i += 2) {
            rowsInline.add(getInlineKeyboardButtonWithURL(vacancy[i + 1], vacancy[i]));
        }

        markupInline.setKeyboard(rowsInline);

        return SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text("All actual vacancies for " + jobTitle + ": ")
                .replyMarkup(markupInline)
                .build();
    }

    public static List<InlineKeyboardButton> getInlineKeyboardButton(String button) {
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(button);
        inlineKeyboardButton.setCallbackData(button);

        rowInline.add(inlineKeyboardButton);

        return rowInline;
    }

    public static List<InlineKeyboardButton> getInlineKeyboardButtonWithURL(String button, String url) {
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(button);
        inlineKeyboardButton.setCallbackData(button);
        inlineKeyboardButton.setUrl(url);

        rowInline.add(inlineKeyboardButton);

        return rowInline;
    }
}
