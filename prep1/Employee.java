package prep1;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Employee {
    public String name;
    public String surname;
    public String position;
    public static HashMap<String,HashMap<String, Double>> allWorkers;

    public Employee(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }
    public abstract void payment();

    public HashMap<String,HashMap<String, Double>> getAllWorkers(){
        return allWorkers;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }
    public abstract double getPayment();
}
