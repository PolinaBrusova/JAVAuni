package Control;

import java.util.ArrayList;
import java.util.HashMap;

public class Table extends Place{
    public static final String ANSI_RESET = "\u001B[0m";//сброс цвета (оригинальный цвет)
    public static final String ANSI_RED = "\u001B[31m";//красный цвет
    private DisEventHandler disEventHandler;
    public String number;
    public HashMap<String, ArrayList<Double>> menu;
    public HashMap<String, ArrayList<Double>> productsForTable;

    public Table(String number, HashMap<String, ArrayList<Double>> menu){
        //проверяем, заняты ли столики вообще и свободен ли тот, который пытаются занять
        if (Place.places.isEmpty()){
            this.number = number;
            this.menu = menu;
            this.productsForTable = new HashMap<>();
            this.disEventHandler = new DisEventHandler();
            Place.places.add(number);
        }else{
            if(Place.places.contains(number)){
                System.out.println(ANSI_RED+"Данный столик ("+number+") уже занят"+ANSI_RESET);
            }else{
                this.number = number;
                this.menu = menu;
                this.productsForTable = new HashMap<>();
                this.disEventHandler = new DisEventHandler();
                Place.places.add(number);
            }
        }
    }

    public void tableInfo(){
        //выводим информацию о блюдах для столика
        ArrayList<String> nums = new ArrayList<>();
        nums.add("1");
        nums.add("2");
        nums.add("3");
        nums.add("4");
        nums.add("5");
        nums.add("6");
        nums.add("7");
        nums.add("8");
        nums.add("9");
        nums.add("0");
        if (!productsForTable.isEmpty()){
            System.out.println("Cтолик ("+number+"): информация о заказе");
            for(String key: productsForTable.keySet()){
                StringBuilder check = new StringBuilder(key);
                int counter = 0;
                //находим, где начинается уникальный ключ
                for (int i =0; i<check.length(); i++){
                    if (nums.contains(String.valueOf(check.charAt(i)))){
                        counter = i;
                        break;
                    }
                }
                //удаляем уникальный ключ
                if (counter!=0){
                    check.delete(counter, check.length());
                }
                System.out.println(check);
            }
            System.out.println();
        }else{
            System.out.println("Столик ("+number+") пока что не совершил заказа");
        }
    }

    public void addProduct(String prodName){
        //столик заказывает блюдо
        ArrayList<Double> contents = this.menu.get(prodName);
        if (productsForTable.isEmpty()){
            productsForTable.put(prodName, contents);
        }else{
            StringBuilder prod = new StringBuilder(prodName);
            prod.append(System.currentTimeMillis());//добавление уникального ключа в виде
                                                    // текущего времени (если одного блюда несколько штук)
            productsForTable.put(prod.toString(), contents);
        }
        disEventHandler.note(prodName, this.number);//уведомляем о выносе блюда для столика
    }

    public void FinalReceipt(){
        //Вывод итогового счета и закрытие столика
        ArrayList<String> nums = new ArrayList<>();
        nums.add("1");
        nums.add("2");
        nums.add("3");
        nums.add("4");
        nums.add("5");
        nums.add("6");
        nums.add("7");
        nums.add("8");
        nums.add("9");
        nums.add("0");
        double summ = 0.0;
        System.out.println("------------СЧЕТ СТОЛА "+number+"---------------");
        for(String key: productsForTable.keySet()){
            StringBuilder check = new StringBuilder(key);
            int counter = 0;
            //находим, где начинается уникальный ключ
            for (int i =0; i<check.length(); i++){
                if (nums.contains(String.valueOf(check.charAt(i)))){
                    counter = i;
                    break;
                }
            }
            //удаляем уникальный ключ
            if (counter!=0){
                check.delete(counter, check.length());
            }
            check.append("--------");
            check.append(productsForTable.get(key).get(0));
            check.append("р");
            summ = summ + productsForTable.get(key).get(0);
            System.out.println(check.toString());
        }
        System.out.println("ИТОГО: "+summ+"р");
        Place.places.remove(number);//удаляем номер столика из списка занятых столиков
    }
}
