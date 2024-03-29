package org.example.keyboardMarkup;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static org.example.keyboardMarkup.KeyboardMarkup.getInlineKeyboardButton;

public class KeyboardCategories {
    public static SendMessage sendInlineKeyBoardMessageForCategories(Long chatId) {
        List<String> categories = new ArrayList<>();

        for (Category category : Category.values()) {
            categories.add(category.getCategory());
        }

        return addNewInlineKeyboardMessageForCategories(chatId, categories);
    }

    private static SendMessage addNewInlineKeyboardMessageForCategories(Long chatId, List<String> categories) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        for (String category : categories) {
            rowsInline.add(getInlineKeyboardButton(category));
        }

        markupInline.setKeyboard(rowsInline);

        return SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text("Please indicate your desired area of employment:")
                .replyMarkup(markupInline)
                .build();
    }
}
