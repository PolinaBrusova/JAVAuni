package Control;

public class DisEventHandler implements DishEvent {
    public static final String ANSI_BLUE = "\u001B[34m"; //голубой цвет
    public static final String ANSI_RESET = "\u001B[0m"; //сброс цвета (оригинальный цвет)

    @Override
    public void note(String dish, String table) {
        //уведомление о выносе блюда для столика
        System.out.println(ANSI_BLUE+"*********************    "+dish+" подано на столик "+table+ANSI_RESET);
    }
}
