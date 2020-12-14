import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) {
        // запускаем нашу примитивную бд
        MyBotDB myBotDB = new MyBotDB();

        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Регистрируем нашего бота
        try {
            Weatherbot weatherbot = new Weatherbot(myBotDB);
            botsApi.registerBot(weatherbot);
            while(true){
                // Отсылаем рассылки подписчикам
                weatherbot.sendSubs();
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
