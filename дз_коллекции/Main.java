package  дз_коллекции
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> coll = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i < 7) {
                coll.add(0);
            } else {
                coll.add(1);
            }
        }
        System.out.println(coll);
        System.out.println(Collections1.NotDup(coll));
        ArrayList<Double> test1 = new ArrayList<>();
        LinkedList<Double> test2 = new LinkedList<>();
        Collections1.adding(test1, test2);
        ArrayList<String> text = new ArrayList<>();
        text.add("Apple");
        text.add("grapE");
        text.add("apPle");
        Collections1.DicBuild("text was Generated by! Polina. By by...");

        System.out.println("Изначальный массив:");
        Integer[][] matrix = {{1, 2, 3}, {3, 2}};
        String[] iter = {"1", "2", "3"};
        for (Integer[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("Вывод на экран:");
        Iterator<Integer> iterator = new Collections2.MatrixIterator<>(matrix);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
