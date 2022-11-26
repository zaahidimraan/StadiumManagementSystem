package BusinessLogic.EntAss;

import DBHandling.EntAssDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class EntAss {
    private Integer CNIC;
    private String name;
    private Integer Pnumber;

    private ArrayList<BookingAss> bookingA=new ArrayList<BookingAss>();

    public ArrayList<BookingAss> getBookingA(Integer CNIC) throws SQLException {
        EntAssDB db=new EntAssDB();
        bookingA=db.getBookingEnt(CNIC);
        return bookingA;
    }

    public void addBooking(Integer CNIC,String M_ID,String date,String time) throws SQLException {
        EntAssDB db=new EntAssDB();
        db.addBooking(CNIC,M_ID,date,time);
        bookingA=db.getBookingEnt(CNIC);
    }
    public EntAss(Integer CNIC, String name, Integer pnumber) {
        this.CNIC = CNIC;
        this.name = name;
        Pnumber = pnumber;
    }

    public Integer getCNIC() {
        return CNIC;
    }

    public void setCNIC(Integer CNIC) {
        this.CNIC = CNIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPnumber() {
        return Pnumber;
    }

    public void setPnumber(Integer pnumber) {
        Pnumber = pnumber;
    }
}
