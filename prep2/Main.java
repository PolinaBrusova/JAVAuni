package prep2;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Terminal terminal = new Terminal();
        App app = new App();
        ATM atm = new ATM();
        OnceCard card1 = new OnceCard(102937);
        SocialCard card2 = new SocialCard(934748, "Student");
        app.fill(card1, 150);
        app.fill(card2, 285);
        terminal.pass(card1);
        terminal.show();
    }
}
