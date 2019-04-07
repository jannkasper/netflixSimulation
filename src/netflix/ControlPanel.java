package netflix;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/** Class ControlPanel keep all informations about Products, Users, Distributors, Subscriptions and Promotions in ArrayLists format */
public class ControlPanel implements Runnable, Serializable {
    private static double accountBalance =0;
    public static Calendar calendar = Calendar.getInstance();
    private static ArrayList<User> listUser = new ArrayList<User>();
    private static ArrayList<Distributor> listDistributor = new ArrayList<Distributor>();
    private static ArrayList<Product> listProduct = new ArrayList<Product>();

    private static ArrayList<Promotion> listPromotion = new ArrayList<Promotion>();
    private static ArrayList<Subscription> listSubscription = new ArrayList<Subscription>();
    private static ArrayList<Double> accountBalancePerMonth = new ArrayList<>();
    private static ArrayList<Date> accountBalanceDate = new ArrayList<>();

    private static int indexCountProduct = 0;
    private static int indexCountUser = 0;
    private static int indexCountDistributor = 0;
    private static int indexCountPromotion = 0;

    public static int getIndexCountProduct() {
        indexCountProduct++;
        return indexCountProduct; }

    public static int getIndexCountUser() {
        indexCountUser++;
        return indexCountUser; }

    public static int getIndexCountDistributor() {
        indexCountDistributor++;
        return indexCountDistributor; }

    public static int getIndexCountPromotion() {
        indexCountPromotion++;
        return indexCountPromotion;
    }
/** Make serialization by creating new Obejcts with not static ArrayList elements*/
    public static void writeToFile () throws IOException {
         SerializationClass serializationObject = new SerializationClass(accountBalance, calendar, listUser, listDistributor, listProduct, listPromotion, listSubscription, accountBalancePerMonth, accountBalanceDate, indexCountProduct, indexCountUser, indexCountDistributor, indexCountPromotion);
         try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("JavaSerialize"))) {
             objectOutputStream.writeObject(serializationObject);
         } catch (Exception e) {
             e.printStackTrace();
         }


     }
    /** Load all information saved by serialization*/
    public static void readFile () throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("JavaSerialize"));
        SerializationClass serializationObject  = (SerializationClass) objectInputStream.readObject();

        accountBalance = serializationObject.getAccountBalance();
        calendar = serializationObject.getCalendar();
        listUser = serializationObject.getListUser();
        listDistributor = serializationObject.getListDistributor();
        listProduct = serializationObject.getListProduct();
        listPromotion = serializationObject.getListPromotion();
        listSubscription = serializationObject.getListSubscription();
        accountBalancePerMonth = serializationObject.getAccountBalancePerMonth();
        accountBalanceDate = serializationObject.getAccountBalanceDate();
        indexCountProduct = serializationObject.getIndexCountProduct();
        indexCountUser = serializationObject.getIndexCountUser();
        indexCountDistributor =serializationObject.getIndexCountDistributor();
        indexCountPromotion = serializationObject.getIndexCountPromotion();
    }

    /** Creating random Distributors during simulation */
    public void run () {
        Distributor create = new Distributor();
        addDistributor(create);
        Long start = calendar.getTimeInMillis();
        System.out.println("---START SIMULATION---");
        run_time();
        run_products();
        run_users();

        while (true) {
            Long end =  calendar.getTimeInMillis();
            if (TimeUnit.MILLISECONDS.toDays(Math.abs(end - start)) > 5) {
                create = new Distributor();
                RandomFill.generateListProduct(create);
                addDistributor(create);
                start = calendar.getTimeInMillis();
            }
            if (TimeUnit.MILLISECONDS.toDays(Math.abs(end - start)) > 10) {
                int number = RandomFill.generateNumber(0, sizePromotion());
                for (int i =0; i<ProductSize(); i++) {
                    listProduct.get(i).setPromotion(listPromotion.get(number));
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
    /** Creating random Products during simulation*/
    public void run_products() {
        Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean notPaid = true;
                while (true) {
                    if (ProductSize() < distributorSize() * 7) {
                        for (int i = 0; i < RandomFill.generateNumber(0, distributorSize() * 7 - ProductSize()); i++) {
                            Product create = RandomFill.generateProduct();
                            addProduct(create);
                        }
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        time.start();
    }
    /** Creat random Users during simulation*/
    private void run_users() {
        Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean notPaid = true;
                while (true) {

                    if (userSize() < ProductSize() * 10) {
                        for (int i = 0; i < RandomFill.generateNumber(0, ProductSize() * 10 - userSize()); i++) {
                            User create = new User();
                            addUser(create);
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        time.start();
    }
    /** Thread set up local time in simulation with information about amount of users, products, distributors, accountBalance*/
    private void run_time() {
        Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean notPaid = true;
                while (true) {
                    calendar.add(Calendar.MINUTE, 1200);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    System.out.println(String.format(dateFormat.format(calendar.getTime()) + "\tUSERS: " + userSize() + "\tPRODUCTS: " + ProductSize() + "\t\tDISTRIBUTROS: " + distributorSize() + "\tCASH: " + new DecimalFormat("#0.00").format(accountBalance)));
                    if (calendar.get(Calendar.DAY_OF_MONTH) == 10 && notPaid) {
                        run_transactions();
                        notPaid = false;
                    }
                    if (ControlPanel.getCalendar().get(Calendar.DAY_OF_MONTH) < 5 ) {
                        notPaid = true;
                    }
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        time.start();
    }
    /** Every 10th each month program take money from Users and pay Distributors */
    private static void run_transactions() {
        Thread transactions = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i<userSize();i++) {
                    accountBalance+=listUser.get(i).getSubscription().getPriceSubscription();
                }

                for (int i =0; i<distributorSize(); i++) {
                    accountBalance-=listDistributor.get(i).getAmountPerMonth();
                }
                if(accountBalancePerMonth.size() == 0) {
                    accountBalancePerMonth.add(accountBalance);
                    accountBalanceDate.add(calendar.getTime());
                } else {
                    accountBalancePerMonth.add(accountBalance - accountBalancePerMonth.get(accountBalancePerMonth.size() - 1));
                    accountBalanceDate.add(calendar.getTime());
                }
                if (accountBalancePerMonth.size()>=3 && accountBalancePerMonth.get(accountBalancePerMonth.size()-1) < 0 && accountBalancePerMonth.get(accountBalancePerMonth.size()-2) < 0 && accountBalancePerMonth.get(accountBalancePerMonth.size()-3) < 0) {
                    NumberFormat formatter = new DecimalFormat("#.##");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM.yyyy");
                    System.out.println("----THE SYSTEM BRINGS A LOSS OF MONEY---\n" + dateFormat.format(accountBalanceDate.get(accountBalanceDate.size()-3)) + " : " + formatter.format(accountBalancePerMonth.get(accountBalancePerMonth.size()-3)) + "\n" +
                            dateFormat.format(accountBalanceDate.get(accountBalanceDate.size()-2)) +" : " + formatter.format(accountBalancePerMonth.get(accountBalancePerMonth.size()-2)) + "\n" +
                            dateFormat.format(accountBalanceDate.get(accountBalanceDate.size()-1)) +" : " + formatter.format(accountBalancePerMonth.get(accountBalancePerMonth.size()-1)));
                    System.exit(0);
                }
            }
        });
        transactions.start();
    }

    public static Calendar getCalendar() {
        return calendar;
    }

    public static synchronized void setAccountBalance(double amount) {
        ControlPanel.accountBalance += amount;
    }

    //  ----------------------------------------------- ABOUT DISTRIBUTOR ------------------------------------------------------
    public static int distributorSize() {
        return listDistributor.size();
    }
    public static Distributor getDistributor (int i) { return listDistributor.get(i); }
    public static void addDistributor(Distributor newDistributor) {
        listDistributor.add(newDistributor);
        newDistributor.start();}
    public static void addRandomDistributor(Distributor newDistributor) {
        listDistributor.add(newDistributor);
        newDistributor.setListProduct(RandomFill.generateListProduct(newDistributor));
        newDistributor.start();
    }
    public static Distributor searchDistributor(String text) {
        for (int i = 0; i<distributorSize(); i++) {
            if (listDistributor.get(i).getNameDistributor().toLowerCase().contains(text.toLowerCase()))
            {
                return getDistributor(i);

            }
        }
        return null;
    }
    public static Distributor findDistributorByIndex (int index) {
        for (int i =0; i<distributorSize(); i++ ){
            if (index == listDistributor.get(i).getIndexDistributor()) {
                return listDistributor.get(i);
            }
        }
        return null;
    }
    //  ----------------------------------------------- ABOUT PRODUCT ------------------------------------------------------
    public static int ProductSize() { return listProduct.size(); }
    public static void addProduct(Product newProduct){
        listProduct.add(newProduct);
        newProduct.getDistributor().addProduct(newProduct);
//        for (int i =0; i < listDistributor.size(); i++) {
//            if (newProduct.getDistributor().getIndexDistributor() == listDistributor.get(i).getIndexDistributor()) {
//                listDistributor.get(i).addProduct(newProduct);
//            }
//        }
    }
    public void changePriceProduct (String title, double price) {
        for (int i =0; i<listProduct.size(); i++) {
            if (listProduct.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                listProduct.get(i).setPrice(price);
            }
        }
    }
    public static void viewList () {
        System.out.println("--FULL LIST OF PRODUCTS--");
        for(int i = 0; i <listProduct.size(); i++)
            System.out.println(i+1 + ". " +listProduct.get(i).getTitle() );
    }
    public void searchTitleAndActor (String text) {
        System.out.println("--RESOULT OF SEARCH--");
        for (int i =0; i <listProduct.size(); i++) {
            if (listProduct.get(i).getTitle().toLowerCase().contains(text.toLowerCase())) {
                System.out.println((i+1) + ". " + listProduct.get(i).getTitle());
                continue;
            }
            String[] actors = listProduct.get(i).getActors();
            for (int j = 0; j<actors.length; j++){
                if(actors[j].toLowerCase().contains(text.toLowerCase())) {
                    System.out.println((i+1) + ". " + listProduct.get(i).getTitle() + ", actors: " + listProduct.get(i).getActors());
                    break;
                }

            }
        }
    }
    public void searchTitle (String text) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getTitle().toLowerCase().contains(text.toLowerCase())) {
                listProduct.get(i).toPrint();
                break;
            }
        }
    }
    public static Product findProductByIndex (int index) {
        for (int i =0; i<ProductSize(); i++ ){
            if (index == listProduct.get(i).getIndexProduct()) {
                return listProduct.get(i);
            }
        }
        return null;
    }
    //  ----------------------------------------------- ABOUT PROMOTION ------------------------------------------------------
    public static Promotion getPromotion (int i) { return listPromotion.get(i); }
    public void addPromotion(Promotion promotion) {
        listPromotion.add((promotion));
    }
    public int sizePromotion () {return listPromotion.size();}
    //  ----------------------------------------------- ABOUT USER ------------------------------------------------------
    public static void addUser(User newUser) {
        newUser.start();
        listUser.add(newUser);}
    public static int userSize() { return listUser.size(); }


    //  ----------------------------------------------- ABOUT SUBSCRIPTION ------------------------------------------------------
    public void addSubscription(Subscription subscription) { listSubscription.add(subscription);}
    public static Subscription getSubscription (int i) { return listSubscription.get(i);}
    public static int sizeSubscription(){ return listSubscription.size();}
    /** Find subcription object by title and change it price*/
    public void changePriceSubscription(String title, double price){
        for (int i =0; i< listSubscription.size();i++){
            if (listSubscription.get(i).getNameSubscription().toLowerCase().contains(title.toLowerCase())) {
                listSubscription.get(i).setPriceSubscription(price);
            }
        }
    }


    public static ArrayList<Distributor> getListDistributor() {
        return listDistributor;
    }

    public static ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public static ArrayList<Promotion> getListPromotion() {
        return listPromotion;
    }

    public static ArrayList<Subscription> getListSubscription() {
        return listSubscription;
    }

    public static ArrayList<User> getListUser() {
        return listUser;
    }

    public static void deleteListDistributor(int position) {
        for (int i =0; i<ProductSize(); i++) {
            if (listProduct.get(i).getDistributor() == listDistributor.get(position)) {
                listProduct.remove(i);
            }
        }
        listDistributor.remove(position);

    }

    public static void deleteListProduct(int position) {
        listProduct.remove(position);
    }


    public static void deleteListUser(int position) {
        listUser.remove(position);
    }

}




