package BusinessLogic.Person;

public class seatDetail {
    private Integer seatNumber;
    private String seatType;
    private Double price;
    private String M_ID;
    private Payment payment;
    private OrderFood orderFood;

    public seatDetail(Integer seatNumber, String seatType, Double price, String m_ID, OrderFood orderFood) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        M_ID = m_ID;
        this.orderFood = orderFood;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderFood getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(OrderFood orderFood) {
        this.orderFood = orderFood;
    }
}
