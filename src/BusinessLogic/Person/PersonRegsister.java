package BusinessLogic.Person;

import DBHandling.PersonDB;

import java.security.PrivateKey;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonRegsister {
    private Integer CNIC;
    private Integer index;
    private String M_ID;
    public String getM_ID() {
		return M_ID;
	}

	public void setM_ID(String m_ID) {
		this.M_ID = m_ID;
	}

	ArrayList<Person> personArrayList=new ArrayList<Person>();

    public void addPerson(Integer CNIC, String name) throws SQLException {

        personArrayList.add(new Person(CNIC,name));
        PersonDB db=new PersonDB();
        db.addPerson(new Person(CNIC,name));
    }

    public void updatePerson(Integer CNIC, String name) throws SQLException {

        PersonDB db=new PersonDB();
        db.updatePerson(new Person(CNIC,name));
    }

    public void removePerson(Integer CNIC,String name) throws SQLException {

        PersonDB db=new PersonDB();
        db.removePerson(new Person(CNIC,name));
    }

    public void addSeatDetail(Integer seatNumber, String seatType, Double price, String m_ID, OrderFood orderFood){
       personArrayList.get(index).addSeatDetail(seatNumber,seatType,price,m_ID,orderFood);
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

    public ArrayList<Person> getPersonArrayList() throws SQLException {
        PersonDB db=new PersonDB();
        personArrayList=db.getPersonArray();
        return personArrayList;
    }



    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }
}
