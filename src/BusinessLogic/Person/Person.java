package BusinessLogic.Person;

import java.util.ArrayList;

public class Person {
  Integer CNIC;
  String name;
  private seatDetail seat;

  public seatDetail getSeat() {
    return seat;
  }

  public void setSeat(Integer seatNumber, String seatType, Double price, String m_ID, Integer F_ID,Double Fprice) {
    this.seat = new seatDetail(seatNumber, seatType, price, m_ID,F_ID,Fprice);
  }

  public Person(Integer CNIC, String name){
    this.CNIC = CNIC;
    this.name = name;
  }
  public Person(Integer CNIC, String name,Integer seatNumber, String seatType, String m_ID,Integer F_ID) {
    this.CNIC = CNIC;
    this.name = name;
    Double price=0.0;
    Double Fprice=0.0;
    if(seatType.equals("A")) {
      price=1500.0;
      if(F_ID==1)
        Fprice=1000.0;
      else if(F_ID==2)
        Fprice=800.0;
      else if (F_ID==3) {
        Fprice=500.0;
      }
    }
    else if(seatType.equals("B")){
      price=1000.0;
      if(F_ID==1)
        Fprice=1000.0;
      else if(F_ID==2)
        Fprice=800.0;
      else if (F_ID==3) {
        Fprice=500.0;
      }
    }
    else if(seatType.equals("C")){
      price=500.0;
      if(F_ID==1)
        Fprice=1000.0;
      else if(F_ID==2)
        Fprice=800.0;
      else if (F_ID==3) {
        Fprice=500.0;
      }
    }
    seat=new seatDetail(seatNumber, seatType, price, m_ID,F_ID,Fprice);
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


  public void addPayment(Double payment, Boolean paymentStatus, String paymentMethod){
    seat.setPayment(new Payment(payment,paymentStatus,paymentMethod));
  }



  public Payment getPayment(){
    return seat.getPayment();
  }

  public OrderFood getOrderFood(){
    return seat.getOrderFood();
  }
}
