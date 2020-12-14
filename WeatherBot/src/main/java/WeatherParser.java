import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class WeatherParser {
    // Ключ от нашего бота
    private final String key = "f5f3c38cc7efcdad1cc6b2986f0d01bc";

    public WeatherParser() {
    }

    public HashMap<String, ArrayList<String>> get5x3weather(String city) {
        // Получаем прогноз погоды на 5 дней с шагом в три часа
        try {
            HashMap<String, ArrayList<String>> info = new HashMap<String, ArrayList<String>>();
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + key);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            JSONObject jsonObj = new JSONObject(content.toString().replace('"', '\"'));
            in.close();
            con.disconnect();
            JSONArray hours = (JSONArray) jsonObj.get("list");
            // Берем первые 8 отчетов по три часа - итого получаются сутки
            for (int i = 0; i < 8; i++) {
                // Конвертируем в JSON
                JSONObject elem = hours.getJSONObject(i);
                // Берем необходимые нам поля
                String time = elem.getString("dt_txt").split(" ")[1].split(":")[0] + ":" +
                        elem.getString("dt_txt").split(" ")[1].split(":")[1];
                String date = elem.getString("dt_txt").split(" ")[0].split("-")[2] + "-" +
                        elem.getString("dt_txt").split(" ")[0].split("-")[1];
                String picLink = "https://openweathermap.org/img/wn/" + new JSONObject(elem.get("weather")
                        .toString().replace("[", "").replace("]", ""))
                        .get("icon").toString() + "@2x.png";
                String temp = WeatherParser.converter(new JSONObject(elem.get("main")
                        .toString()).get("temp").toString());
                String humi = new JSONObject(elem.get("main").toString()).get("humidity").toString();
                String weather = WeatherParser.translate(new JSONObject(elem.get("weather")
                        .toString().replace("[", "").replace("]", ""))
                        .get("description").toString());
                String wSpeed = new JSONObject(elem.get("wind").toString()).get("speed").toString();
                ArrayList<String> for_info = new ArrayList<String>();
                for_info.add(date);
                for_info.add(time);
                for_info.add(weather);
                for_info.add(temp);
                for_info.add(humi);
                for_info.add(wSpeed);
                for_info.add(picLink);
                info.put(Integer.toString(i), for_info);
            }
            return info;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> currentWeater(String city) {
        // Получаем погоду в текущий момент времени
        try {
            ArrayList<String> info = new ArrayList<String>();
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Конвертируем в JSON
            JSONObject jsonObj = new JSONObject(content.toString().replace('"', '\"'));
            in.close();
            con.disconnect();
            // Берем необходимые нам поля
            String temp = WeatherParser.converter(new JSONObject(jsonObj.get("main")
                    .toString()).get("temp").toString());
            String humi = new JSONObject(jsonObj.get("main").toString()).get("humidity").toString();
            String weather = WeatherParser.translate(new JSONObject(jsonObj.get("weather")
                    .toString().replace("[", "").replace("]", ""))
                    .get("description").toString());
            String wSpeed = new JSONObject(jsonObj.get("wind").toString()).get("speed").toString();
            String picLink = "https://openweathermap.org/img/wn/"
                    + new JSONObject(jsonObj.get("weather").toString().replace("[", "")
                    .replace("]", "")).get("icon").toString() + "@2x.png";
            info.add(weather);
            info.add(temp);
            info.add(humi);
            info.add(wSpeed);
            info.add(picLink);
            return info;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String converter(String temp) {
        //Переводим температуру из Кельвинов в градусы по Цельсию
        return String.format("%.0f", Double.parseDouble(temp) - 273.15);
    }

    public static String translate(String line) {
        String[] nline = line.split(" ");
        //Переводим необходимые слова на русский (с сайта приходит ответ на английском)
        ArrayList<String> en = new ArrayList<String>();
        ArrayList<String> ru = new ArrayList<String>();
        en.add("overcast clouds");
        ru.add("пасмурно");
        en.add("moderate");
        ru.add("умеренный");
        en.add("light breeze");
        ru.add("легкий ветерок");
        en.add("light");
        ru.add("мелкий");
        en.add("clear sky");
        ru.add("ясно");
        en.add("scattered clouds");
        ru.add("малооблачно");
        en.add("broken clouds");
        ru.add("малооблачно");
        en.add("gentle");
        ru.add("легкий");
        en.add("few clouds");
        ru.add("малооблачно");
        en.add("rain and snow");
        ru.add("дождь и снег");
        en.add("breeze");
        ru.add("ветер");
        en.add("clouds");
        ru.add("облака");
        en.add("rain");
        ru.add("дождь");
        en.add("snow");
        ru.add("снег");
        en.add("haze");
        ru.add("туман");
        if (en.contains(line)) {
            return ru.get(en.indexOf(line));
        } else {
            StringBuffer ans = new StringBuffer();
            for (String word : nline) {
                ans.append(ru.get(en.indexOf(word)));
                ans.append(" ");
            }
            ans.setLength(ans.length() - 1);
            return ans.toString();
        }
    }
}
