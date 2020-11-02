package prep1;
import java.io.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean type = true;
        ArrayList<Employee> employees = new ArrayList<>();
        if (type){
            employees = Main.read("employees.txt");
        }else{
            employees.add(new TimeEmp("Иван", "Иванов", "Уборщик", 30000));
            employees.add(new TimeEmp("Петр", "Петров", "Секретарь", 60000));
            employees.add(new WageEmp("Александр", "Смирнов", "Стажер", 300));
            employees.add(new WageEmp("Анастасия", "Кулешова", "Промоутер", 250));
            employees.add(new TimeEmp("Анатолий", "Покеров", "Топ-менеджер", 90000));
        }
        if(employees.size()>0){
            employees.sort(Comparator.comparing(Employee::getPayment).reversed().thenComparing(Employee::getSurname));
            System.out.println("----------TOP5-----------------");
            for (int i=0; i<5; i++){
                System.out.println(employees.get(i).getName()+" "+employees.get(i).getSurname()+" "+employees.get(i).getPayment());
            }
            System.out.println("----------ANTI-TOP3------------");
            for(int i = employees.size()-1; i > employees.size()-4; i--){
                System.out.println(employees.get(i).getName()+" "+employees.get(i).getSurname()+" "+employees.get(i).getPayment());
            }
            Main.showCast(employees);
            Main.write(employees);
        }
    }

    public static ArrayList<Employee> read(String path) {
        ArrayList<Employee> list = new ArrayList<>();
        ArrayList<String> nameSurnames = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String worker = bufferedReader.readLine();
            while (worker != null) {
                String nameSur = worker.split(" ")[0] + " " + worker.split(" ")[1];
                String position = worker.split(" ")[2];
                double wage = Double.parseDouble(worker.split(" ")[3]);
                if (wage < 2000) {
                    list.add(new WageEmp(nameSur.split(" ")[0], nameSur.split(" ")[1], position, wage));
                } else {
                    list.add(new TimeEmp(nameSur.split(" ")[0], nameSur.split(" ")[1], position, wage));
                }
                worker = bufferedReader.readLine();
            }
            return list;
        } catch (FileNotFoundException e) {
                e.printStackTrace();
                return list;
            } catch (IOException e) {
                e.printStackTrace();
                return list;
            }
    }

    public static void showCast(ArrayList<Employee> list) {
        System.out.println("---------------ALL EMPLOYEES--------------");
        for (Employee emp: list) {
            System.out.println(emp.getName() + " " + emp.getSurname());
            System.out.println("          "+emp.getPosition());
            if (emp.getClass() == WageEmp.class){
                System.out.println("          "+((WageEmp) emp).getPayment()+" ("+((WageEmp) emp).getWageHour()+" в час)");
            }else {
                System.out.println("          "+((TimeEmp) emp).getPayment()+" (фиксированная)");
            }
        }
    }

    public static void write(ArrayList<Employee> list) throws IOException {
        FileWriter writer = new FileWriter("employees.txt");
        for (Employee emp: list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(emp.getName());
            stringBuilder.append(" ");
            stringBuilder.append(emp.getSurname());
            stringBuilder.append(" ");
            stringBuilder.append(emp.getPosition());
            stringBuilder.append(" ");
            if(emp.getClass() == WageEmp.class){
                stringBuilder.append(((WageEmp) emp).getWageHour());
            }else{
                stringBuilder.append(((TimeEmp) emp).getPayment());
            }
            stringBuilder.append("\n");
            writer.write(stringBuilder.toString());
        }
        writer.flush();
    }
}
