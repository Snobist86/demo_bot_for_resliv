package com.pankov.demo_bot_for_resliv.service;

import com.pankov.demo_bot_for_resliv.exception.ResourceNotFoundException;
import com.pankov.demo_bot_for_resliv.service.impl.InfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:telegram.properties")
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    private final InfoService infoService;

    public Bot(InfoService infoService) {
        this.infoService = infoService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String request = update.getMessage().getText();
//        sendInfo(update, request);
        if (request.isEmpty() || request.contains("/start")){
            sendInfo(update, "Введите название города, пожалуйста.");
        } else {
            try{
                String response = infoService.findByCityName(request).getDescription();
                sendInfo(update, response);
            } catch ( ResourceNotFoundException e){
                sendInfo(update, "Города с таким названием нет в нашей базе.");
            }
        }

    }

    private void sendInfo(Update update, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}

