package BusinessLogic.Person;

import java.util.ArrayList;

public class Person {
  Integer CNIC;
  String name;
  ArrayList<seatDetail> seats=new ArrayList<seatDetail>();

  private Integer index;

  public Person(Integer CNIC, String name) {
    this.CNIC = CNIC;
    this.name = name;
  }

  public void setCNIC(Integer CNIC) {
    this.CNIC = CNIC;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCNIC() {
    return CNIC;
  }

  public String getName() {
    return name;
  }

  public ArrayList<seatDetail> getSeats() {
    return seats;
  }

  public void addSeatDetail(Integer seatNumber, String seatType, Double price, String m_ID, Payment payment, OrderFood orderFood){
    seats.add(new seatDetail(seatNumber,seatType,price,m_ID,payment,orderFood));
  }

  public void addOrderFood(Integer foodID, Double ptice){
    seats.get(index).setOrderFood(new OrderFood(foodID,ptice));
  }

  public void addPayment(Double payment, Boolean paymentStatus, String paymentMethod){
    seats.get(index).setPayment(new Payment(payment,paymentStatus,paymentMethod));
  }

  public Integer getIndex() {
    return index;
  }

  public void setIndex(String M_ID,Integer seatNo) {
    for(int i=0;i<seats.size();i++){
      if((M_ID.equals(seats.get(i).getM_ID()))&&(seatNo.equals(seats.get(i).getSeatNumber())))
        index=i;
    }
    this.index = index;
  }

  public Payment getPayment(){
    return seats.get(index).getPayment();
  }
  public seatDetail getSeatDetail(){
    return seats.get(index);
  }

  public OrderFood getOrderFood(){
    return seats.get(index).getOrderFood();
  }
}
