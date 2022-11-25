package BusinessLogic.OrderFood;

import java.util.ArrayList;

public class FoodDeal {
    private Integer foodDealID;
    private Double price;
    private String name;
    private ArrayList<FoodItem> foodItems=new ArrayList<FoodItem>();

    public FoodDeal(Integer foodDealID, Double price, String name) {
        this.foodDealID = foodDealID;
        this.price = price;
        this.name = name;
    }

    public Integer getFoodDealID() {
        return foodDealID;
    }

    public void setFoodDealID(Integer foodDealID) {
        this.foodDealID = foodDealID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFoodItem(String itemID,Double price1){
        foodItems.add(new FoodItem(itemID,price1));
        this.price=this.price+price1;
    }
}
