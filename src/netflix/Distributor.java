package netflix;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Distributor extends Thread implements Serializable {
    private int indexDistributor;
    private String nameDistributor;
    private long accountNumber;
    private double amountToPay;
    private double amountPerView;
    private double amountPerMonth;
    private ArrayList<Product> listProduct = new ArrayList<>();
    /** Creating new Distributor with settings*/
    public Distributor(String nameDistributor, long accountNumber, double amountPerView, double amountPerMonth) {
        this.indexDistributor = ControlPanel.getIndexCountDistributor();
        this.nameDistributor = nameDistributor;
        this.accountNumber = accountNumber;
        this.amountToPay = 0;
        this.amountPerView = amountPerView;
        this.amountPerMonth = amountPerMonth;
    }
    /** Creating new Random Distributor*/
    public Distributor() {
        this.indexDistributor = ControlPanel.getIndexCountDistributor();
        this.nameDistributor = RandomFill.generateCompany();
        this.accountNumber = RandomFill.generateNumber(10000000, 99999999)*10000000 + RandomFill.generateNumber(10000000, 99999999);
        this.amountToPay = 0;
        if (RandomFill.generateNumber(0,1) == 1) {
            this.amountPerView = RandomFill.generateNumber(20,50)/10;
            this.amountPerMonth = 0;
        } else {
            this.amountPerView = 0;
            this.amountPerMonth = RandomFill.generateNumber(10000, 30000);
        }
    }
    /** Thread with possibility to renegotiates the contract for distirbutor*/
    public void run () {
        while (true) {
            for (int i = 0; i <20 ; i++) {
                if (20*ControlPanel.ProductSize() < ControlPanel.userSize() ) {
                    Product nextProd = RandomFill.generateProduct();
                    nextProd.setDistributor(ControlPanel.findDistributorByIndex(this.indexDistributor));
                    ControlPanel.addProduct(nextProd);
                }
            }
            int decisionRandome = RandomFill.generateNumber(0,2);
            if (decisionRandome == 1) {
                ControlPanel.calendar.add(Calendar.MINUTE, 1200);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                System.out.println(String.format(dateFormat.format(ControlPanel.calendar.getTime()) + "\tDISTRIBUTOR RENEGOTIATES CONTRACT: " + this.nameDistributor ));
                if (amountPerMonth == 0) {
                    this.amountPerView *= 1.05;
                    this.amountPerMonth *= 0.95;
                } else {
                    this.amountPerView *= 0.95;
                    this.amountPerMonth *= 1.05;
                }
            }

            try {
                Thread.sleep(RandomFill.generateNumber(3000,20000));
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }

    }

    public int getIndexDistributor() {
        return indexDistributor;
    }

    public double getAmountPerView() {
        return amountPerView;
    }

    public double getAmountPerMonth() {
        return amountPerMonth;
    }

    public void addProduct (Product nextProduct) { listProduct.add(nextProduct); }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getNameDistributor() {
        return this.nameDistributor;
    }
    public void deleteProduct() {}
    public void changeContract() {}

    @Override
    public String toString() {

        return "Distributor details" +
                "\nindexDistributor:\t" + indexDistributor +
                "\nnameDistributor:\t'" + nameDistributor + '\'' +
                "\naccountNumber:\t" + accountNumber +
                "\namountToPay:\t" + amountToPay +
                "\namountPerView:\t" + amountPerView +
                "\namountPerMonth:\t" + amountPerMonth;
    }


}
