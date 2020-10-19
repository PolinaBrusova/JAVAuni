public class Main1 {
    public static void main(String[] args) {
        USB undostringbuilder = new USB();
        undostringbuilder.append("Первое слово");
        System.out.println(undostringbuilder.toString());
        undostringbuilder.replace(0,0,"УЖЕ ВТОРОЕ, а не ");
        System.out.println(undostringbuilder.toString());
        undostringbuilder.delete(0,17);
        System.out.println(undostringbuilder.toString());
        undostringbuilder.reverse();
        System.out.println(undostringbuilder.toString());
        undostringbuilder.undo();
        System.out.println(undostringbuilder.toString());
        undostringbuilder.undo();
        System.out.println(undostringbuilder.toString());
    }
}
