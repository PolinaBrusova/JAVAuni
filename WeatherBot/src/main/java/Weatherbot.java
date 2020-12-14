import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Weatherbot extends TelegramLongPollingBot {
    private Message prev_message = new Message();
    private MyBotDB myBotDB;
    private WeatherParser weatherParser = new WeatherParser();

    public Weatherbot(MyBotDB myBotDB){
        this.myBotDB = myBotDB;
    }

    public void setPrev_message(Message prev_message) {
        this.prev_message = prev_message;
    }

    public String getPrev_message() {
        if (prev_message.getText() == null){
            return "no";
        }else{
            return prev_message.getText();
        }
    }

    public void onUpdateReceived(Update update) {
        // Обрабатываем приходящие сообщения
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/start")) {
                sendStart(message);
                setPrev_message(message);
            } else if (message.getText().equals("/help")) {
                sendHelp(message);
                setPrev_message(message);
            } else if (message.getText().equals("/fun")) {
                sendJoke(message);
                setPrev_message(message);
            } else if (message.getText().equals("/today")) {
                sendCityInfo(message);
                setPrev_message(message);
            } else if (message.getText().equals("/subscribe")) {
                askSubCity(message);
                setPrev_message(message);
            } else if (getPrev_message().equals("/subscribe")) {
                if (message.getText().equals("q")) {
                    decline(message);
                } else {
                    executeSub(message);
                }
            } else if (message.getText().equals("/unsubscribe")) {
                executeUnSub(message);
            } else if (getPrev_message().equals("/today")) {
                weatherToday(message);
            } else {
                unknown(message);
            }
        }else{
            unknown(message);
        }
    }

    public String getBotUsername() {
        return "TheWeatherJava_bot";
    }

    public String getBotToken() {
        return "1460141660:AAH_z_GF0D2JTKlgpMsIroOHKJJySIs1tCI";
    }

    public void sendStart(Message message) {
        // Функция отправки стартового сообщения
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId());  // чат, в который отправляем сообщение
        String start = "Привет!\nЯ, YourWeather, бот, способный рассказать тебе по сегодняшнюю погоду " +
                "в твоём городе!\n\nНапиши /help, если хочешь узнать подробнее о работе со мной";
        sendMessage.setText(start);
        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendHelp(Message message) {
        // Функция отправки сообщения с помощью
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId());  // чат, в который отправляем сообщение
        String help = "Сейчас расскажу про все мои команды!\n\n/start - начать работу с ботом и получить" +
                " приветственное сообщение\n/help - получить информацию по работе с ботом\n/today - получить текущую " +
                "погоду и прогноз на день в зависимости от местоположения\n/subscribe - подписаться на ежедневную " +
                "бесплатную рассылку прогноза погоды на день\n/unsubscribe - отписаться от ежедневной рассылки\n/fun" +
                " - бот отправит веселую шутку про погоду\n\nПриятного пользования!";
        sendMessage.setText(help);
        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendJoke(Message message){
        // Функция отправки анекдотов
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId());  // чат, в который отправляем сообщение
        ArrayList<String> jokes = new ArrayList<String>();
        jokes.add("Снег ещё никогда так низко не падал.");
        jokes.add("Из-за аномально тёплой погоды в России распустилось правительство.");
        jokes.add("Однажды я не хотел выходить на улицу, пока там идет дождь. Так прошел июль.");
        jokes.add("Интересно: \n" +
                "Кто в Гидрометцентре главный ощущатель, который оценивает ощущаемую температуру?");
        jokes.add("Коммунальные службы учли ошибки прошлых лет и так хорошо подготовились к зиме, что убирают снег " +
                "сразу из прогноза погоды.");
        jokes.add("Они нам погоду на завтра правильно предсказать не могут, зато про COVID они уверенно доказывают.");
        jokes.add("- В такую погоду совсем не хочется работать. \n- В какую? \n- В любую.\n");
        jokes.add("И коротко о погоде: давайте никуда не пойдем");
        jokes.add("У природы нет плохой погоды. Но хорошей тоже.");
        int joke_ind = new Random().nextInt(jokes.size());
        sendMessage.setText(jokes.get(joke_ind));
        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendCityInfo(Message message) {
        // Функция выяснения места для получения текущего прогноза по месту
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId());  // чат, в который отправляем сообщение
        String query = "Отправь мне название места, погоду которого ты хочешь узнать!";
        sendMessage.setText(query);
        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void askSubCity(Message message) {
        //Функция выяснения у пользователя города для оформления подписки
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId());  // чат, в который отправляем сообщение
        String query = "По какому городу ты хочешь оформить бесплатную подписку на рассылку " +
                "суточного прогноза погоды?\nНапиши q, если подписка не нужна!";
        sendMessage.setText(query);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void decline(Message message) {
        // Функция отказа от регистрации подписки
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId());  // чат, в который отправляем сообщение
        String dec = "Ох, отмена регистрации подписки...";
        sendMessage.setText(dec);
        try {
            execute(sendMessage);
            setPrev_message(new Message());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executeSub(Message message) {
        // Функция оформления подписки
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId()); // чат, в который отправляем сообщение
        sendMessage.setReplyToMessageId(message.getMessageId()); // Пересылаем сообщение, на которое отвечаем
        // Проверяем существование города
        if (check_for_subs(message.getText())) {
            // На реальный город оформляем подписку
            // И отправляем уведомление о ее оформлении
            String ans = myBotDB.addSub(message.getChatId().toString(), message.getText()) + "\n\nЕё всегда можно " +
                    "отменить командой /unsubscribe";
            sendMessage.setText(ans);
            try {
                execute(sendMessage);
                setPrev_message(new Message());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else{
            // На неправильное написание места отправляем уведомление об ошибке
            sendMessage.setText("Такого места не существует!");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeUnSub(Message message) {
        // Функция отмены подписки
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId()); // чат, в который отправляем сообщение
        sendMessage.setReplyToMessageId(message.getMessageId()); // Пересылаем сообщение, на которое отвечаем
        String ans = myBotDB.stopSub(message.getChatId().toString()); //Останавливаем подписку
        sendMessage.setText(ans); // Отправляем оповещение об остановке подписки
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendSubs(){
        // Отправка сообщений всем, у кого активная подписка
        for(String key: myBotDB.getDb().keySet()){
            // Проверяем, есть ли подписка и прошли ли сутки с даты прошлой отправки
            if (myBotDB.getDb().get(key).get("status").equals("on") && myBotDB.checkDate(key)){
                // Запрашиваем прогноз по городу в подписке
                HashMap<String, ArrayList<String>> for_future = weatherParser.get5x3weather(myBotDB.getDb()
                        .get(key).get("city"));
                // Формируем ответ по полученным данным
                for (String k: for_future.keySet()){
                    ArrayList<String> info = for_future.get(k);
                    SendPhoto newsendPhoto = new SendPhoto();
                    newsendPhoto.setChatId(key);
                    newsendPhoto.setPhoto(info.get(6));
                    newsendPhoto.setCaption("------"+info.get(0)+" в "+info.get(1)+"------\n\nНа улице "
                            +info.get(2)+"\nТемпература "+info.get(3)+"℃\nВлажность воздуха "+info.get(4)
                            +"%\nСкорость ветра "+info.get(5)+" м/с");
                    try {
                        execute(newsendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void weatherToday(Message message){
        // Функция отправки текущей погоды по месту
        try {
            // Останавливаемся для получения запроса
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String> now = weatherParser.currentWeater(message.getText());
        HashMap<String, ArrayList<String>> for_future = weatherParser.get5x3weather(message.getText());
        if (now == null || for_future == null){
            SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true); // включить возможность разметки
            sendMessage.setChatId(message.getChatId()); // чат, в который отправляем сообщение
            sendMessage.setReplyToMessageId(message.getMessageId()); // Пересылаем сообщение, на которое отвечаем
            sendMessage.setText("Такого места не существует!"); // Отправляем текст о нереальности места
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else {
            // Формируем ответ по полученным с сайта данным о погоде
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(message.getChatId());
            sendPhoto.setCaption("------ПРЯМО СЕЙЧАС------\n\nНа улице "+now.get(0)+"\nТемпература "
                    +now.get(1)+"℃\nВлажность воздуха "+now.get(2)+"%\nСкорость ветра "+now.get(3)+" м/с");
            sendPhoto.setPhoto(now.get(4));
            try {
                execute(sendPhoto);
                setPrev_message(new Message());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            // формируем сообщения для прогноза на сутки
            for (String key: for_future.keySet()){
                ArrayList<String> info = for_future.get(key);
                SendPhoto newsendPhoto = new SendPhoto();
                newsendPhoto.setChatId(message.getChatId());
                newsendPhoto.setPhoto(info.get(6));
                newsendPhoto.setCaption("------"+info.get(0)+" в "+info.get(1)+"------\n\nНа улице "
                        +info.get(2)+"\nТемпература "+info.get(3)+"℃\nВлажность воздуха "+info.get(4)
                        +"%\nСкорость ветра "+info.get(5)+" м/с");
                try {
                    execute(newsendPhoto);
                    setPrev_message(new Message());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void unknown(Message message){
        // Функция обработки всех неизвестных боту сообщений
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true); // включить возможность разметки
        sendMessage.setChatId(message.getChatId()); // чат, в который отправляем сообщение
        sendMessage.setText("Прости, но такого я понять не могу..."); // текст сообщения
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public boolean check_for_subs(String city){
        // Проверяем, есть ли такой город, отправляя тестовый запрос на сайт. Мониторинг правильности
        // написания названия места
        ArrayList<String> now = weatherParser.currentWeater(city);
        return now != null;
    }
}
