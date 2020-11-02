package prep2;

public class OnceCard extends Card{
    public double balance;
    public int passes;

    public OnceCard(int num){
        super(num);
        balance = 0;
        passes = 0;
    }

    @Override
    public int getNum() {
        return super.getNum();
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
