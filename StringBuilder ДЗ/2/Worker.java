class Worker implements Observer {
    public void onChange(String action, java.lang.StringBuilder stringBuilder) {
        System.out.println("Уведомление об изменениях\n    Действие: " + action+
                ",  Результат: "+stringBuilder.toString());
    }
}
