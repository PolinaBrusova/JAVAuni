package  дз_коллекции
import java.util.*;

public class Collections1 {
    public static <T> Collection <T> NotDup(Collection <T> col){
        java.util.Set <T> set = new HashSet<>(col);
        return set;
    }
    public static void adding(ArrayList<Double> mylist, LinkedList<Double> mylinked){
        long starttime = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            double a = Math.random()*1000000;
            mylist.add(a);
        }
        System.out.println("total time for array: " + (System.currentTimeMillis()-starttime));
        starttime = System.currentTimeMillis();
        for(int i=0; i<1000000; i++){
            double a = Math.random()*1000000;
            mylinked.add(a);
        }
        System.out.println("total time for linked: " + (System.currentTimeMillis()-starttime));
    }
    public static void DicBuild(String text){
        text = text.replace(".", "");
        text = text.replace(",", "");
        text = text.replace("!", "");
        text = text.replace(":", "");
        text = text.replace(";", "");
        text = text.replace("?", "");
        text = text.replace("...", "");
        text = text.replace("-", "");
        String[] newtext = text.split(" ");
        ArrayList<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(newtext));
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.size(); i++){
            words.set(i, words.get(i).toLowerCase());
        }
        for (String word : words) {
            map.compute(word, ((String, integer) -> integer==null ? 1: integer +1));
        }
        System.out.println(map);
    }
}
