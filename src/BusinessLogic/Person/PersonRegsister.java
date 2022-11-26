package BusinessLogic.Person;

import java.security.PrivateKey;
import java.util.ArrayList;

public class PersonRegsister {
    private Integer CNIC;
    private Integer index;

    ArrayList<Person> personArrayList=new ArrayList<Person>();

    public void addPerson(Integer CNIC, String name){
        personArrayList.add(new Person(CNIC,name));
    }

    public void addSeatDetail(Integer seatNumber, String seatType, Double price, String m_ID, Payment payment, OrderFood orderFood){
       personArrayList.get(index).addSeatDetail(seatNumber,seatType,price,m_ID,payment,orderFood);
    }

    public void addOrderFood(Integer foodID, Double price){
       personArrayList.get(index).addOrderFood(foodID,price);
    }

    public void addPayment(Double payment, Boolean paymentStatus, String paymentMethod){
        personArrayList.get(index).addPayment(payment,paymentStatus,paymentMethod);
    }

    public Payment getPayment(){
        return personArrayList.get(index).getPayment();
    }
    public seatDetail getSeatDetail(){
        return personArrayList.get(index).getSeatDetail();
    }

    public OrderFood getOrderFood(){
        return personArrayList.get(index).getOrderFood();
    }

    public Integer getCNIC() {
        return CNIC;
    }

    public void setCNIC(Integer CNIC) {
        this.CNIC = CNIC;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex() {
        for(int i=0;i<personArrayList.size();i++)
         if(CNIC.equals(personArrayList.get(i).getCNIC()))
             index=i;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }
}
