package Control;

import java.util.ArrayList;
import java.util.HashMap;


public class Menu {
    public HashMap<String, ArrayList<Double>> menu;
    public HashMap<String, ArrayList<Double>> stopList;

    public Menu(){
        this.menu = new HashMap<>();
        this.stopList = new HashMap<>();
    }

    public void addToMenu(String name, HashMap<String, Double> info){
        //Добавляем в меню блюдо как элемент словаря
        double price = info.get("Price");
        double weight = info.get("Weight");
        ArrayList<Double> in = new ArrayList<>();
        in.add(price);
        in.add(weight);
        menu.put(name, in);
        System.out.println("Блюдо "+name+" добавлено!");//уведомляем о добавлении в меню
    }

    public void addToStop(String name){
        //переносим блюдо в стоп-лист с его сокрытием из меню
        if (menu.containsKey(name)){
            stopList.put(name, menu.get(name));
            menu.remove(name);
            System.out.println("Блюдо "+name+" перенесено в стоп-лист");
        }else{
            System.out.println("Вы не можете добавить "+name+" в стоп-лист, так как его нет в меню");
        }
    }

    public void removeFromMenu(String name){
        //удаляем блюдо из меню
        if (menu.containsKey(name)){
            menu.remove(name);
            System.out.println("Блюдо "+name+" удалено из меню");
        }else{
            System.out.println("Блюдо "+name+" не может быть удалено, так как его итак нет в меню!");
        }
    }

    public void removeFromStop(String name){
        //удаляем блюдо из стоп-листа в созвращением его в меню
        if (stopList.containsKey(name)){
            menu.put(name, stopList.get(name));
            stopList.remove(name);
            System.out.println("Блюдо "+name+" удалено из стоп-листа и включено обратно в меню");
        }else{
            System.out.println("Блюдо "+name+" не может быть удалено, так как его итак нет в Стоп-листе!");
        }
    }
    //метод возвращает словарь меню
    public HashMap<String, ArrayList<Double>> getMenu(){
        return this.menu;
    }

    public void show(){
        //вывод текущего меню
        System.out.println("-------------MENU--------------");
        for(String prod: menu.keySet()){
            StringBuilder product = new StringBuilder(prod);
            product.append("----");
            product.append(menu.get(prod).get(0));
            product.append("р./");
            product.append(menu.get(prod).get(1));
            product.append("г.");
            System.out.println(product.toString());
        }
    }
}
