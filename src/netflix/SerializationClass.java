package netflix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SerializationClass implements Serializable {
    private  double accountBalance;
    private  Calendar calendar = Calendar.getInstance();
    private  ArrayList<User> listUser = new ArrayList<User>();
    private  ArrayList<Distributor> listDistributor = new ArrayList<Distributor>();
    private  ArrayList<Product> listProduct = new ArrayList<Product>();

    private  ArrayList<Promotion> listPromotion = new ArrayList<Promotion>();
    private  ArrayList<Subscription> listSubscription = new ArrayList<Subscription>();
    private  ArrayList<Double> accountBalancePerMonth = new ArrayList<>();
    private  ArrayList<Date> accountBalanceDate = new ArrayList<>();

    private int indexCountProduct;
    private int indexCountUser;
    private int indexCountDistributor;
    private int indexCountPromotion;

    public SerializationClass(double accountBalance, Calendar calendar, ArrayList<User> listUser, ArrayList<Distributor> listDistributor, ArrayList<Product> listProduct, ArrayList<Promotion> listPromotion, ArrayList<Subscription> listSubscription, ArrayList<Double> accountBalancePerMonth, ArrayList<Date> accountBalanceDate, int indexCountProduct, int indexCountUser, int indexCountDistributor, int indexCountPromotion) {
        this.accountBalance = accountBalance;
        this.calendar = calendar;
        this.listUser = listUser;
        this.listDistributor = listDistributor;
        this.listProduct = listProduct;
        this.listPromotion = listPromotion;
        this.listSubscription = listSubscription;
        this.accountBalancePerMonth = accountBalancePerMonth;
        this.accountBalanceDate = accountBalanceDate;
        this.indexCountProduct = indexCountProduct;
        this.indexCountUser = indexCountUser;
        this.indexCountDistributor = indexCountDistributor;
        this.indexCountPromotion = indexCountPromotion;

    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public ArrayList<Distributor> getListDistributor() {
        return listDistributor;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public ArrayList<Promotion> getListPromotion() {
        return listPromotion;
    }

    public ArrayList<Subscription> getListSubscription() {
        return listSubscription;
    }

    public ArrayList<Double> getAccountBalancePerMonth() {
        return accountBalancePerMonth;
    }

    public ArrayList<Date> getAccountBalanceDate() {
        return accountBalanceDate;
    }

    public int getIndexCountProduct() {
        return indexCountProduct;
    }

    public int getIndexCountUser() {
        return indexCountUser;
    }

    public int getIndexCountDistributor() {
        return indexCountDistributor;
    }

    public int getIndexCountPromotion() {
        return indexCountPromotion;
    }
}
