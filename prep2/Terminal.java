package prep2;

import java.util.Date;
import java.util.HashMap;

public class Terminal {
    public static HashMap<String, Double> statistics;
    public static HashMap<String, Double> prices;

    public Terminal(){
        statistics = new HashMap<>();
        statistics.put("Проходимость", 0.0);
        statistics.put("Заработано", 0.0);
        statistics.put("Поштучных", 0.0);

        prices = new HashMap<>();
        prices.put("Student", 285.0);
        prices.put("School", 235.0);
        prices.put("Social", 235.0);
        prices.put("Pass", 55.0);
        prices.put("Card-pass", 44.0);
    }

    public void pass(Card card){
        if (card.getClass() == OnceCard.class){
            if (((OnceCard) card).getPasses() > 0){
                ((OnceCard) card).setPasses(((OnceCard) card).getPasses()-1);
                System.out.println("Списана 1 поездка");
                Terminal.statistics.put("Проходимость", Terminal.statistics.get("Проходимость")+1);
                Terminal.statistics.put("Поштучных", Terminal.statistics.get("Поштучных")+1);
            }else if (((OnceCard) card).getBalance()>Terminal.prices.get("Pass")){
                ((OnceCard) card).setBalance(((OnceCard) card).getBalance()-Terminal.prices.get("Pass"));
                System.out.println("Списано "+Terminal.prices.get("Pass")+" рублей за поездку. Проездных не было.");
                Terminal.statistics.put("Проходимость", Terminal.statistics.get("Проходимость")+1);
                Terminal.statistics.put("Заработано", Terminal.statistics.get("заработано")+Terminal.prices.get("Pass"));
            }else{
                System.out.println("недостаточно средств. Доступных поездок не обнаружено");
            }
        }else if (card.getClass() == SocialCard.class){
            if (((SocialCard) card).isStatus()){
                System.out.println("Социальная карта активна. Поездка засчитана");
                Terminal.statistics.put("Проходимость", Terminal.statistics.get("Проходимость")+1);
            }else{
                System.out.println("Социальная карта не действительна. Пополните баланс.");
            }
        }
    }

    public void show(){
        System.out.println("------СТАТИСТИКА ПО ТЕРМИНАЛУ ЗА "+ new Date().toString()+"---------");
        for (String key: statistics.keySet()){
            System.out.println(key+" : "+statistics.get(key));
        }
    }
}
