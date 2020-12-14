import java.util.*;

public class MyBotDB {
    private HashMap<String, HashMap<String, String>> db = new HashMap<String, HashMap<String, String>>();
    private final Date date = new Date();
    private final GregorianCalendar calendar = new GregorianCalendar();

    public MyBotDB() {
    }

    public HashMap<String, HashMap<String, String>> getDb() {
        return db;
    }

    public void setDb(HashMap<String, HashMap<String, String>> db) {
        this.db = db;
    }

    public String addSub(String id, String city) {
        // добавление подписки
        if (db != null) {
            if (db.containsKey(id)) {
                if (db.get(id).get("status").equals("on")) {
                    // случай, когда подписка оформлена и город совпадает
                    if (db.get(id).get("city").equals(city)) {
                        return "Ты уже оформил подписку на этот город!\n\nДата подписки: " +
                                db.get(id).get("sub_date");
                    } else {
                        // случай, когда подписка уже существует, но в запросе пришел другой город
                        db.get(id).put("city", city);
                        db.get(id).put("sub_date", date.toString());
                        return "Ты успешно сменил город для получения ежедневной рассылки\n\nДата смены города: " +
                                db.get(id).get("sub_date");
                    }
                } else {
                    // случай, когда подписка уже была оформлена раньше и была остановлена
                    db.get(id).put("city", city);
                    db.get(id).put("sub_date", date.toString());
                    db.get(id).put("status", "on");
                    return "Ты успешно возобновил подписку для получения ежедневной рассылки\n\nДата возобновления: " +
                            db.get(id).get("sub_date");
                }
            } else {
                // случай новой подписки
                db.put(id, new HashMap<String, String>());
                db.get(id).put("city", city);
                db.get(id).put("sub_date", date.toString());
                db.get(id).put("status", "on");
                db.get(id).put("last", String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)));
                return "Ты успешно подписался на получение ежедневной рассылки\n\nДата подписки: " +
                        db.get(id).get("sub_date");
            }
        } else {
            // случай, когда бд пустая
            HashMap<String, String> contains = new HashMap<String, String>();
            contains.put("city", city);
            contains.put("sub_date", date.toString());
            contains.put("status", "on");
            contains.put("last", String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)));
            db.put(id, contains);
            return "Ты успешно подписался на получение ежедневной рассылки\n\nДата подписки: " +
                    db.get(id).get("sub_date");
        }
    }

    public String stopSub(String id) {
        // функция остановки подписки
        if (db.containsKey(id)) {
            if (db.get(id).get("status").equals("off")){
                return "Твоя подписка уже остановлена.\nТы можешь подписаться на рассылку снова по команде /subscribe";
            }else {
                db.get(id).put("status", "off");
                return "Отписка от рассылки выполнена!";
            }
        } else {
            return "А подписки и не было(";
        }
    }

    public String getLast(String id) {
        if (db.containsKey(id)) {
            return db.get(id).get("last");
        } else {
            return "";
        }
    }

    public void setLast(String id) {
        if (db.containsKey(id)) {
            db.get(id).put("last", String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)));
        }
    }

    public boolean checkDate(String id) {
        // Функция проверки необходимости отсылки информации по подписке
        if (db.containsKey(id)) {
            try {
                if (Integer.parseInt(this.getLast(id)) != Integer.parseInt(String.valueOf(calendar.get(Calendar.DAY_OF_YEAR)))){
                    this.setLast(id);
                    return true;
                }else{
                    return false;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
