package BusinessLogic.OrderFood;

public class FoodItem {

    private String itemID;
    private Double price;

    public FoodItem(String itemID, Double price) {
        this.itemID = itemID;
        this.price = price;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
