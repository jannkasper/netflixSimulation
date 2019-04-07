package netflix;

import java.io.Serializable;
import java.util.Date;

public class Promotion implements Serializable {
    private int indexPromotion;
    private String namePromotion;
    private Date startDate;
    private Date endDate;
    private int discountValue;

    /** Creating new Promotion with settings*/
    public Promotion(String namePromotion, Date startDate, Date endDate, int discountValue) {
        this.indexPromotion = ControlPanel.getIndexCountPromotion();
        this.namePromotion = namePromotion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountValue = discountValue;
    }
    /** Creating new Random Promotion*/
    public Promotion () {
        this.indexPromotion = ControlPanel.getIndexCountPromotion();
        this.namePromotion = RandomFill.generateString(5);
        this.startDate = new Date();
        this.endDate = RandomFill.generateFutureDate();
        this.discountValue = RandomFill.generateNumber(5,50);

    }

    public String getNamePromotion() {
        return namePromotion;
    }
}
