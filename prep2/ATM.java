package prep2;

import java.io.IOException;
import java.util.Scanner;

public class ATM {
    private Scanner in;

    public ATM(){
        this.in = new Scanner(System.in);
    }

    public Card fill(Card card, double summa) throws IOException {
        if (card.getClass() == OnceCard.class) {
            System.out.println("У вас карта с поразовой оплатой. Желаете приобрести " + Math.floor(summa / Terminal.prices.get("Card-pass")) + " поездок?");
            System.out.println("Введите 1 - если желаете:");
            int ans = in.nextInt();
            if (ans==1){
                ((OnceCard) card).setPasses((int) Math.floor(summa / Terminal.prices.get("Card-pass")));
            }else{
                ((OnceCard) card).setBalance(summa);
            }
        }else if(card.getClass() == SocialCard.class) {
            if (((SocialCard) card).isStatus()) {
                System.out.println("Ваша карта все еще действиет! Пополните ее позже");
            } else {
                System.out.println("Ваша карта типа " + ((SocialCard) card).getType());
                System.out.println("Стоимость месячного пользования " + Terminal.prices.get(((SocialCard) card).getType()));
                if (summa>=Terminal.prices.get(((SocialCard) card).getType())){
                    ((SocialCard) card).setStatus(true);
                    System.out.println("Карта Оплачена на сумму "+Terminal.prices.get(((SocialCard) card).getType()));
                }else{
                    System.out.println("Введенной суммы для оплаты не достаточно.");
                }
            }
        }
        return card;
    }
}
