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
		System.out.println(m_ID);
	}

	ArrayList<Person> personArrayList=new ArrayList<Person>();

    public void addPerson(Integer CNIC, String name,Integer seatNumber,String SeatType,Integer foofid) throws SQLException {

        personArrayList.add(new Person(CNIC,name));
        PersonDB db=new PersonDB();
        db.addPerson(new Person(CNIC,name,seatNumber,SeatType,M_ID,foofid));
    }



    public void removePerson(Integer CNIC,String name) throws SQLException {

        PersonDB db=new PersonDB();
        db.removePerson(CNIC,name,M_ID);
        
    }

    public void addSeatDetail(Integer seatNumber, String seatType, Double price, String m_ID, Integer F_ID,Double Fprice){
       personArrayList.get(index).setSeat(seatNumber, seatType, price, m_ID,F_ID,Fprice);
    }


    public void addPayment(Double payment, Boolean paymentStatus, String paymentMethod){
        personArrayList.get(index).addPayment(payment,paymentStatus,paymentMethod);
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

    public void setIndex(Integer CNIC) {
        for(int i=0;i<personArrayList.size();i++)
         if(CNIC==personArrayList.get(i).getCNIC())
             index=i;
    }

    public ArrayList<Person> getPersonArrayList(Integer CNIC) throws SQLException {
        PersonDB db=new PersonDB();
        personArrayList=db.getPersonArray(M_ID,CNIC);
        return personArrayList;
    }


    public Payment getPayment() throws SQLException {
        PersonDB db=new PersonDB();
        return db.getPayment(personArrayList.get(index));
    }

    public void updatePayment(Boolean status,String paymentM) throws SQLException {
        Person p=personArrayList.get(index);
        p.getSeat().getPayment().setPaymentMethod(paymentM);
        p.getSeat().getPayment().setPaymentStatus(status);
        PersonDB db=new PersonDB();
        db.updatePayment(p);
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }
}
