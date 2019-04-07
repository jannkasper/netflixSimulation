package netflix;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LiveStream extends Product implements Serializable {
    private Date date;
    private double price;
    private Promotion promotion;

    /** Creating new LiveStream with setting*/
    public LiveStream(String title, String description, int duration, Distributor distributor, String[] country, double score, Date date, double price) {
        super(title, description, duration, distributor, country, score);
        this.date = date;
        this.price = price;
        this.promotion = ControlPanel.getPromotion(0);

    }
    /** Creating new Random LiveStream*/
    public LiveStream() {
        super();
        this.date = RandomFill.generateFutureDate();
        this.price = RandomFill.generateNumber(20,50);
        this.promotion = ControlPanel.getPromotion(0);
    }

    public void toPrint() {
        super.toPrint();
        SimpleDateFormat tempDate = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(
                "date=" + tempDate.format(date) +
                "\nprice=" + price +
                "\npromotion=" + promotion );
    }

    @Override
    public String toString() {
        SimpleDateFormat tempDate = new SimpleDateFormat("dd-MM-yyyy");
        return super.toString() +
                "\nDate:\t\t\t" + tempDate.format(date) +
                "\nPrice:\t\t\t" + price +
                "\nPromotion:\t\t" + promotion.getNamePromotion();
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void deleteProduct() {}
    public void writeDownProduct() {}


}
