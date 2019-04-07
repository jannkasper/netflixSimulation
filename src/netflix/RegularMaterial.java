package netflix;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class RegularMaterial extends Product implements Serializable {
    private Date productionDate;
    private String type;
    private String[] actors;
    /** Creating new Regular material with settings*/
    public RegularMaterial(String title, String description, int duration, Distributor distributor, String[] country, double score, Date productionDate, String type, String[] actors) {
        super(title, description, duration, distributor, country, score);
        this.productionDate = productionDate;
        this.type = type;
        this.actors = actors;
    }
    /** Creating new Random Regular material*/
    public RegularMaterial () {
        super ();
        this.productionDate = RandomFill.generatePastDate();
        this.type =RandomFill.generateType();
        this.actors = RandomFill.generateActors();
    }


    public void toPrint() {
        super.toPrint();
        SimpleDateFormat tempDate = new SimpleDateFormat("MM-yyyy");
        System.out.println(
                "productionDate=" + tempDate.format(productionDate) +
                "\ntype='" + type + '\'' +
                "\nactors=" + Arrays.toString(actors) );
    }

    @Override
    public String toString() {
        SimpleDateFormat tempDate = new SimpleDateFormat("dd-MM-yyyy");
        return super.toString() +
                "\nProduction Date:\t" + tempDate.format(productionDate) +
                "\nType:\t\t\t'" + type + '\'' +
                "\nActors:\t\t\t" + Arrays.toString(actors);
    }

    public void setPrice(double price) { }

    public double getPrice() { return 0;}
    public void deleteProduct() {}
    public void writeDownProduct() {}
    public String[] getActors() {
        return this.actors;
    };
}
