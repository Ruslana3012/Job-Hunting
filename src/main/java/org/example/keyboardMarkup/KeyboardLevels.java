package org.example.keyboardMarkup;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static org.example.keyboardMarkup.KeyboardMarkup.getInlineKeyboardButton;

public class KeyboardLevels {
    public static SendMessage sendInlineKeyBoardMessageForDeveloper(Long chatId, String language) {
        return addNewInlineKeyBoardMessageForLevels(chatId, language);
    }

    private static SendMessage addNewInlineKeyBoardMessageForLevels(Long chatId, String language) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        rowsInline.add(getInlineKeyboardButton(Level.INTERN.getLevel() + " " + language));
        rowsInline.add(getInlineKeyboardButton(Level.TRAINEE.getLevel() + " " + language));
        rowsInline.add(getInlineKeyboardButton(Level.JUNIOR.getLevel() + " " + language));
        rowsInline.add(getInlineKeyboardButton(Level.MIDDLE.getLevel() + " " + language));
        rowsInline.add(getInlineKeyboardButton(Level.SENIOR.getLevel() + " " + language));
        rowsInline.add(getInlineKeyboardButton(language + " Team " + Level.LEAD.getLevel()));

        markupInline.setKeyboard(rowsInline);

        return SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text("Please indicate your level in your area of employment:")
                .replyMarkup(markupInline)
                .build();
    }
}
