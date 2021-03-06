package com.message.bot.channel;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MessageBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()) {

            Message message = update.getMessage();
            long chat_id = update.getMessage().getChatId();
            SendMessage send = new SendMessage().setChatId(chat_id);

            if(message.getText().equals(message.getText())) {
                GlobalVariables.TEXT = message.getText();

                TimerTask task = new TimerTask() {
                        public void run() {
                            System.out.println("before : SendMes.mes(message.getText())");
                            try {
                                SendMes.mes(message.getText());
                                System.out.println("after : SendMes.mes(message.getText())");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    };
                Timer timer = new Timer("Timer");

                timer.schedule(task, 1000L); /// если у нас один пост в боте , то через сутки выводится на канал первый поток.

                try {
                    send.setText("Success");
                    execute(send);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public String getBotUsername() {
        return "property by mrm";
    }

    @Override
    public String getBotToken() {
        return "your_telegram_bot_token";
    }
}
