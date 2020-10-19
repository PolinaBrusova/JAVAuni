import java.util.*;
class StringBuilder {

    // Слушатель, которого надо будет уведомить
    private Observer observer;

    // делегат
    private java.lang.StringBuilder stringBuilder;

    // Сеттер для onChangeListener
    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public StringBuilder() {
        stringBuilder = new java.lang.StringBuilder();
    }

    private void NotifiObserver(String action){
        if(observer != null){
            observer.onChange(action, this.stringBuilder);
        }
    }

    public java.lang.StringBuilder append(Object obj) {
        stringBuilder.append(obj);
        NotifiObserver("append");
        return this.stringBuilder;
    }

    public java.lang.StringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        NotifiObserver("replace");
        return this.stringBuilder;
    }

    public java.lang.StringBuilder insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        NotifiObserver("insert");
        return this.stringBuilder;
    }

    public String toString() {
        return stringBuilder.toString();
    }
}