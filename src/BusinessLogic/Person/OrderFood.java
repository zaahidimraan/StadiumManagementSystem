package BusinessLogic.Person;

public class OrderFood {
    private Integer foodID;
    private Double ptice;

    public OrderFood(Integer foodID, Double ptice) {
        this.foodID = foodID;
        this.ptice = ptice;
    }

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public Double getPtice() {
        return ptice;
    }

    public void setPtice(Double ptice) {
        this.ptice = ptice;
    }
}
