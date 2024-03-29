package org.example.keyboardMarkup;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static org.example.keyboardMarkup.KeyboardMarkup.getInlineKeyboardButton;

public class KeyboardLanguages {
    public static SendMessage sendInlineKeyBoardMessageForLanguages(Long chatId) {
        List<String> languages = new ArrayList<>();

        for (Language language : Language.values()) {
            languages.add(language.getLanguage());
        }

        return addNewInlineKeyboardMessageForLanguages(chatId, languages);
    }

    private static SendMessage addNewInlineKeyboardMessageForLanguages(Long chatId, List<String> languages) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        for (String language : languages) {
            rowsInline.add(getInlineKeyboardButton(language));
        }

        markupInline.setKeyboard(rowsInline);

        return SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text("Please indicate your desired area of employment:")
                .replyMarkup(markupInline)
                .build();
    }
}
