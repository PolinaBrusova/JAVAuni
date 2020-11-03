package Control;

import javax.print.DocFlavor;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Double> conts = new HashMap<>();//словарь для характеристик блюда/напитка
        conts.put("Price", 340.50);
        conts.put("Weight", 300.0);
        Menu menu = new Menu();//открываем меню
        menu.addToMenu("Оливье", conts);//добавляем блюдо с названием и характеристиками
        conts.clear();
        conts.put("Price", 560.90);
        conts.put("Weight", 475.0);
        menu.addToMenu("Ризотто с креветками", conts);
        menu.show();//выводим меню на экран
        menu.addToStop("Оливье");//переносим блюдо в стоп-лист
        menu.show();//снова выводим меню и видим, что блюдо стоп-листа исчезло из меню
        menu.removeFromStop("Оливье");//удаляем из стоп-листа
        menu.show();//снова выводим меню и видим, что блюдо вернулось в меню
        conts.clear();
        conts.put("Price", 80.);
        conts.put("Weight", 330.);
        menu.addToMenu("Кока-кола", conts);
        menu.show();

        Table table1 = new Table("1", menu.getMenu());//открываем столик 1
        Table table2 = new Table("4", menu.getMenu());//открываем столик 4
        table1.addProduct("Ризотто с креветками");//первому столику заказано блюдо - добавляется в счет
        table2.addProduct("Оливье");
        table1.addProduct("Ризотто с креветками");
        table1.addProduct("Оливье");
        table1.tableInfo();//информация по текущему заказу столика
        table1.FinalReceipt();//выводим счет для столика (здесь же столик закрывается
        Table table3 = new Table("4", menu.getMenu());//пытаемся открыть счет на уже занятый столик
    }
}
