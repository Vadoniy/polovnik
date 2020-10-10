package com.polovnikbot.polovnik.bot;

import com.google.gson.Gson;
import com.polovnikbot.polovnik.rest.dto.ReplyToUser;
import com.polovnikbot.polovnik.rest.dto.Result;
import com.polovnikbot.polovnik.rest.dto.YahooResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
@Service
@RequiredArgsConstructor
@EnableAutoConfiguration
public class PolovnikWebhookBot extends TelegramWebhookBot {

    private static final String URL = "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?modules=price";

    @Value("telegrambot.webhook-path")
    private String botPath;
    @Value("telegrambot.user-name")
    private String botUsername;
    @Value("telegrambot.user-token")
    private String botToken;

    private final RestTemplate restTemplate;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendMessage reply = new SendMessage()
                .setChatId(update.getMessage().getChatId());
        try {
            final var quoteSummaryResponse = restTemplate.getForObject(String.format(URL, update.getMessage().getText()), YahooResponse.class);
            final var replyToUserList = quoteSummaryResponse.getQuoteSummary().getResult().stream()
                    .map(this::collectReply)
                    .collect(Collectors.toList());
            reply.setText(replyToUserList.toString());
        } catch (Exception e) {
            reply.setText("Wrong ticket, try again please");
        }

        return reply;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    private ReplyToUser collectReply(Result result) {
        final var price = result.getPrice();
        return ReplyToUser.builder()
                .currency(price.getCurrency())
                .currentPrice(price.getRegularMarketPrice().getRaw().toString())
                .openPrice(price.getRegularMarketOpen().getRaw().toString())
                .previousClosePrice(price.getRegularMarketPreviousClose().getRaw().toString())
                .postmarketPrice(price.getPostMarketPrice().getRaw().toString())
                .name(price.getLongName())
                .build();
    }
}
