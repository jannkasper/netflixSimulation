package netflix;
import javafx.scene.image.Image;

import java.io.File;
import java.io.Serializable;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Product implements Serializable {
    private int indexProduct;
    private String image;
    private String title;
    private String description;
    private int duration;
    private Distributor distributor;
    private String[] country;
    private double score;
    private ArrayList<Date> watchDate = new ArrayList<>();
    private ArrayList<Integer> watchViews = new ArrayList<>();
    /** Creating new Product with settings*/
    public Product(String title, String description, int duration, Distributor distributor, String[] country, double score) {
        this.indexProduct = ControlPanel.getIndexCountProduct();
        this.image = "/Users/jankasper/Desktop/NetflixFX/src/image"+ RandomFill.generateNumber(0,5) +".jpg";
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.distributor = distributor;
        this.country = country;
        this.score = score;
    }
    /** Creating new Random Product*/
    public Product () {
        this.indexProduct = ControlPanel.getIndexCountProduct();
//        File file = new File("/Users/jankasper/Desktop/NetflixFX/src/image"+ RandomFill.generateNumber(0,5) +".jpg");
        this.image = "/Users/jankasper/Desktop/NetflixFX/src/image"+ RandomFill.generateNumber(0,5) +".jpg";
        this.title = RandomFill.generateTitle();
        this.description = RandomFill.generateText();
        this.duration = RandomFill.generateNumber(30, 130);
        this.distributor = ControlPanel.getDistributor(RandomFill.generateNumber(0, ControlPanel.distributorSize()));
        this.country = RandomFill.generateCountry();
        this.score = RandomFill.generateNumber(1, 500);
    }

    /** Checking current date then add one */
    public synchronized void watching () {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if ( watchDate.size() == 0) {
//            System.out.println("TEGO DNIA NIE BYLO");
            watchDate.add(ControlPanel.getCalendar().getTime());
            watchViews.add(1);
        } else if (dateFormat.format(watchDate.get(watchDate.size()-1)).equals(dateFormat.format(ControlPanel.getCalendar().getTime()))) {
            int oldVal = watchViews.get(watchViews.size()-1);
            oldVal++;
            watchViews.set(watchViews.size()-1, oldVal);
//            System.out.println("POWIESZKAM WYSWIETLENIE");
        } else {
            watchDate.add(ControlPanel.getCalendar().getTime());
            watchViews.add(1);
//            System.out.println("DODAJE KOLEJNY DZIEN");
        }

    }

    public void toPrint() {
        System.out.println("Product " + title + " :" +
                "\nIndex of Product=" + indexProduct +
                "\ntitle='" + title + '\'' +
                "\ndescription='" + description + '\'' +
                "\nduration=" + duration +
                "\ndistributor=" + distributor +
                "\ncountry=" + Arrays.toString(country) +
                "\nscore=" + score );
    }

    @Override
    public String toString() {
        return "Index of Product:\t" + indexProduct +
                "\nTitle:\t\t\t'" + title + '\'' +
                "\nDescription:\t\t'" + description + '\'' +
                "\nDuration:\t\t\t" + duration + " min" +
                "\nDistributor:\t\t" + distributor.getNameDistributor() +
                "\nCountry:\t\t\t" + Arrays.toString(country) +
                "\nScore:\t\t\t" + score;

    }

    public int getIndexProduct() { return indexProduct; }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor; }

    public Distributor getDistributor() { return distributor; }

    public String getTitle () {
        return this.title;
    }
    public String[] getActors() {
        return null;
    }
    public void setPrice(double price) { }
    public double getPrice() { return 0;}

    public int getWatchViewsSize () {
        return watchViews.size();
    }

    public String getImage() {
        return image;
    }
    public void setPromotion(Promotion promotion) {
    }

    public Date getWatchDateElement (int i) {
        return watchDate.get(i);
    }
    public Integer getWatchViewsElement (int i) {
        return watchViews.get(i);
    }


}
