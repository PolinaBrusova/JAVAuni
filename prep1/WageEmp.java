package prep1;

import java.util.ArrayList;
import java.util.HashMap;

public class WageEmp extends Employee{
    public double wageHour;
    public double payment;

    public WageEmp(String name, String surname, String position, double wageHour){
        super(name, surname, position);
        this.wageHour = wageHour;
        this.payment = 20*8*wageHour;
    }

    @Override
    public void payment() {
        this.payment = 20*8*wageHour;

    }

    public double getWageHour() {
        return wageHour;
    }

    @Override
    public double getPayment() {
        return payment;
    }
}
