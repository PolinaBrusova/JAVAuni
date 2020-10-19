public class Main2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.setObserver(new Worker());
        stringBuilder.append("Hello");
        stringBuilder.append(", ");
        stringBuilder.append("World!");
        stringBuilder.replace(0,5,"Goodbye");
    }
}