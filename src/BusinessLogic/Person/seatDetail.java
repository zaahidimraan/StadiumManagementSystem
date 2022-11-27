package BusinessLogic.Person;

public class seatDetail {
    private Integer seatNumber;
    private String seatType;
    private Double price;
    private String M_ID;
    private Payment payment;
    private OrderFood orderFood;

    public seatDetail(Integer seatNumber, String seatType, Double price, String m_ID, Integer F_ID,Double Fprice) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        M_ID = m_ID;
        orderFood=new OrderFood(F_ID,Fprice);
        payment=new Payment((price+Fprice),false,"Nothing");
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


    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderFood getOrderFood() {
        return orderFood;
    }

}
