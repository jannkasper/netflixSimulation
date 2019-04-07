package netflix;

import java.io.Serializable;

public class Subscription implements Serializable {
    private String nameSubscription;
    private double priceSubscription;
    private int amountDevice;
    private int resolutionMax;

    /** Creating new Subscription with settings*/
    public Subscription(String nameSubscription, double priceSubscription, int amountDevice, int resolutionMax) {
        this.nameSubscription = nameSubscription;
        this.priceSubscription = priceSubscription;
        this.amountDevice = amountDevice;
        this.resolutionMax = resolutionMax;
    }

    public void setPriceSubscription(double priceSubscription) {
        this.priceSubscription = priceSubscription;
    }

    public String getNameSubscription() {
        return nameSubscription;
    }

    public double getPriceSubscription() {
        return priceSubscription;
    }

    @Override
    public String toString() {
        return "Subscription details" +
                "\nnameSubscription:\t'" + nameSubscription + '\'' +
                "\npriceSubscription:\t" + priceSubscription +
                "\namountDevice:\t" + amountDevice +
                "\nresolutionMax:\t" + resolutionMax ;
    }
}
