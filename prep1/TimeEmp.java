package prep1;

import java.util.HashMap;

public class TimeEmp extends Employee{
    public double payment;

    public TimeEmp(String name, String surname, String position, double payment){
        super(name, surname, position);
        this.payment = payment;
    }

    @Override
    public void payment() {}

    @Override
    public double getPayment() {
        return payment;
    }
}
