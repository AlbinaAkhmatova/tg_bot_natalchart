package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class Bot extends TelegramLongPollingBot {
    var page1 = InlineKeyboardButton.builder().text("Calculate natal chart").callbackData("page1").build();
    var page2 = InlineKeyboardButton.builder().text("Read more...").callbackData("page2").build();
    var page3 = InlineKeyboardButton.builder().text("Display aura color").callbackData("page3").build();

    private InlineKeyboardMarkup keyboardM1;
    private InlineKeyboardMarkup keyboardM2;
    private InlineKeyboardMarkup keyboardM3;

    @Override
    public String getBotUsername() {
        return "tg_natal_chart_bot";
    }

    @Override
    public String getBotToken() {
        return "7068011221:AAFHJT-yq9Z8AauLr3PkHN14akpm14vGeHI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        String msgBot = new String("Hello, " + user.getFirstName()+"! I can calculate a natal chart based on your data, namely date of birth, time of birth. If you want to know more about each point, click \"more\". Click on what you want to know!");
        if(msg.isCommand()){
            if(msg.getText().equals("/start"))
                sendText(user.getId(), msgBot);
            return;
        }
    }
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }



}