package com.polovnikbot.polovnik.rest;

import com.polovnikbot.polovnik.bot.PolovnikWebhookBot;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RestController
@AllArgsConstructor
public class WebhookController {

    private PolovnikWebhookBot polovnikWebhookBot;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        log.info("Received message from {}: {}", update.getMessage().getFrom().getUserName(), update.getMessage().getText());
        return polovnikWebhookBot.onWebhookUpdateReceived(update);
    }
}
