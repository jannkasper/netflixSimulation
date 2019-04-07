package netflix;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class User extends Thread implements Serializable {
    private int indexUser;
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
    private long creditCardNumber;
    private Subscription subscription;

    /** Thread with possibility to select random product and take money from user*/
    public void run () {
        while (true) {
            int number = RandomFill.generateNumber(0, ControlPanel.ProductSize());
            ControlPanel.getListProduct().get(number).watching();
            if (this.subscription == ControlPanel.getSubscription(0)) {
                ControlPanel.setAccountBalance(ControlPanel.getListProduct().get(number).getPrice());                                                   // INCREASE ACCOUNT BALANCE BECAUSE USER IS UNSUBSCRIBED
            }
            ControlPanel.setAccountBalance(-ControlPanel.getListProduct().get(number).getDistributor().getAmountPerView());                         // REDUCE ACCOUNT BALANCE PAY PER VIEW

            if (ControlPanel.getListProduct().get(number).getClass() == LiveStream.class && this.subscription != ControlPanel.getSubscription(0)) {   // IF PRODUCT IS LIVESTREAM AND USER HAVE PREMIUM ACCOUNT
                ControlPanel.setAccountBalance(ControlPanel.getListProduct().get(number).getPrice());                                                       //// INCREASE ACCOUNT BY COST OF LIVESTREAM
            }


            try {
                Thread.sleep(RandomFill.generateNumber(200,1000));
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    /** Creating new User with settings*/
    public User(String name, String surname, Date birthDate, String email, long creditCardNumber, Subscription subscription) {
        this.indexUser = ControlPanel.getIndexCountUser();
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
        this.subscription = subscription;
    }
    /** Creating new Randome User*/
    public User() {
        this.indexUser = ControlPanel.getIndexCountUser();
        this.name = RandomFill.generateString(6);
        this.surname = RandomFill.generateString(8);
        this.birthDate = RandomFill.generateBirthdayDate();
        this.email = new StringBuilder().append(this.name).append(".").append(this.surname).append("@gmail.com").toString();
        this.creditCardNumber = RandomFill.generateNumber(10000000, 99999999)*10000000 + RandomFill.generateNumber(10000000, 99999999);
        this.subscription = ControlPanel.getSubscription(RandomFill.generateNumber(0, ControlPanel.sizeSubscription()));
    }


    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public String toString() {
        SimpleDateFormat tempDate = new SimpleDateFormat("dd-MM-yyyy");
        return "User details" +
                "\nindexUser:\t\t\t" + indexUser +
                "\nname:\t\t\t\t'" + name + '\'' +
                "\nsurname:\t\t\t\t'" + surname + '\'' +
                "\nbirthDate:\t\t\t" + tempDate.format(birthDate) +
                "\nemail:\t\t\t\t'" + email + '\'' +
                "\ncreditCardNumber:\t" + creditCardNumber +
                "\nsubscription:\t\t\t" + subscription.getNameSubscription() ;
    }

    public String getUserName() {
        return name;
    }

    public String getUserSurname() {
        return surname;
    }

}
