package netflix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Series extends RegularMaterial implements Serializable {
    private double price;
    private ArrayList<Season> listSeason;
    /** Creating new Series with settings*/
    public Series(String title, String description, int duration, Distributor distributor, String[] country, double score, Date productionDate, String type, String[] actors, double price, ArrayList<Season> listSeason) {
        super(title, description, duration, distributor, country, score, productionDate, type, actors);
        this.price = price;
        this.listSeason = listSeason;
    }
    /** Creating new Random Series*/
    public Series () {
        super();
        this.price = RandomFill.generateNumber(5,15);
        this.listSeason = RandomFill.generateListSeason();
    }


    public void toPrint() {
        super.toPrint();
        System.out.println(
                "price=" + price +
                "\nlistSeason=" + listSeason );
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPrice:\t\t\t" + price +
                "\nNumber of Season: " + listSeason.size() +
                "\nNumber of Episodes: " + listSeason.get(0).getNumberEpisodes();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void deleteProduct() {}
    public void writeDownProduct() {}



}
