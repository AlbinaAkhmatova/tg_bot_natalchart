package tutorial;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "tg_natal_chart_bot";
    }

    @Override
    public String getBotToken() {
        return "7068011221:AAFHJT-yq9Z8AauLr3PkHN14akpm14vGeHI";
    }

    @Override
    public void onUpdateReceived(Update update) {}

}