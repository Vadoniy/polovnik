package com.polovnikbot.polovnik.bot;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class PolovnikLongPollingBot extends TelegramLongPollingBot {

    private static final String TOKEN = "1284777653:AAEYzwhUUvPQgVRIBzkfpmIzvZwlt4pSdC4";

    private static final String USERNAME = "polovnik_bot";

    @Override
    public void onUpdateReceived(Update update) {

        if (update.getMessage() != null && update.getMessage().hasText()) {
            final long chatId = update.getMessage().getChatId();

            try {
                execute(new SendMessage(chatId, update.getMessage().getText()));
            } catch (TelegramApiException ex) {
                log.error(ex.getMessage());
            }
        }

    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
