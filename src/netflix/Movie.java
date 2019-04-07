package netflix;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Movie extends RegularMaterial implements Serializable {
    private String URL;
    private Promotion promotion;
    private double price;
    private int dateLimit;

    /** Creating new Movie with settings*/
    public Movie(String title, String description, int duration, Distributor distributor, String[] country, double score, Date productionDate, String type, String[] actors, String URL, double price, int dateLimit) {
        super(title, description, duration, distributor, country, score, productionDate, type, actors);
        this.URL = URL;
        this.promotion = ControlPanel.getPromotion(0);
        this.price = price;
        this.dateLimit = dateLimit;
    }

    /** Creating new Random Movie*/
    public Movie () {
        super();
        this.URL = new StringBuilder().append("http://goto.com/").append(RandomFill.generateString(7)).toString();
        this.promotion = ControlPanel.getPromotion(0);
        this.price = RandomFill.generateNumber(10,30);
        this.dateLimit = RandomFill.generateNumber(10,60);
    }

    public void toPrint() {
        super.toPrint();
        System.out.println(
                "URL='" + URL + '\'' +
                "\npromotion=" + promotion.getNamePromotion() +
                "\nprice=" + price +
                "\ndateLimit=" + dateLimit);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nURL link:\t\t\t'" + URL + '\'' +
                "\nPromotion:\t\t" + promotion.getNamePromotion() +
                "\nPrice:\t\t\t" + price +
                "\nDate Limit:\t\t" + dateLimit ;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public double getPrice() {
        return price;
    }

    public void deleteProduct() {}
    public void writeDownProduct() {}
}
